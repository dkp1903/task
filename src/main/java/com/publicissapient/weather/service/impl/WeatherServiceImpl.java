
package com.publicissapient.weather.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.publicissapient.weather.client.IWeatherClient;
import com.publicissapient.weather.controller.WeatherController;
import com.publicissapient.weather.exception.BadWeatherDataException;
import com.publicissapient.weather.model.Weather;
import com.publicissapient.weather.model.WeatherObjectList;
import com.publicissapient.weather.model.WeatherForecast;
import com.publicissapient.weather.service.WeatherService;
import com.publicissapient.weather.util.Constants;
import com.publicissapient.weather.util.WeatherUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

/**
 * The implementation class for WeatherService interface.
 * 
 * @see com.publicissapient.weather.service.WeatherService

 */


@Service
public class WeatherServiceImpl implements WeatherService {
    
    /** The logger. */
    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);

    /** The weather client. */
    // @Autowired
    // private IWeatherClient weatherClient;

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String weatherUrl;

    /**
     * Gets the city weather forecast for next three days.
     *
     * @param city the city
     * @return the list of WeatherForecast weather
     *         @see com.publicissapient.weather.model.WeatherForecast
     */
    @Override
    public List<WeatherForecast> getCityWeather(String city) {
        
        LOG.trace("Entering getCityWeather(city={})", city);
        weatherUrl = getWeatherUrl(city);
        Weather cityWeather = restTemplate.getForObject(weatherUrl, Weather.class);
        List<WeatherForecast> dayWeatherList = new ArrayList<>();

        List<WeatherObjectList> threeDaysCityWeather = cityWeather.getList().subList(0, 3);

        for (WeatherObjectList weatherObjectList : threeDaysCityWeather) {
            
             WeatherForecast weatherForecast = new WeatherForecast();
             
            if (weatherObjectList.getMain() != null) {

                weatherForecast.setHigh(weatherObjectList.getMain().getTemp_max());
                weatherForecast.setLow(weatherObjectList.getMain().getTemp_min());

                float temperatureInCelsius = WeatherUtil.convertTempToCelsius(
                        weatherObjectList.getMain().getTemp());

                if (temperatureInCelsius > 40.0) {
                    weatherForecast.setMessage(Constants.USE_SUNSCREEN_LOTION);
                } else if (weatherObjectList.getWeather().get(0).getMain().contains(Constants.RAIN)) {
                    weatherForecast.setMessage(Constants.CARRY_UMBRELLA);
                } else {
                    weatherForecast.setMessage(weatherObjectList.getWeather().get(0).getMain());
                }

            } else {
                LOG.error("Temperature data is missing for the city");
                throw new BadWeatherDataException(Constants.EXTERNAL_API_SENT_MALFORMED_DATA);
            }

            dayWeatherList.add(weatherForecast);
        }

        return dayWeatherList;
    }

    private String getWeatherUrl(String city) {
        String apiKey = "6449bfe949acc1c7c9b003ba7c7660af";
        String baseUrl = "https://api.openweathermap.org/data/2.5/forecast";
        String defaultCity = "Pune";
        try {
            // Encode the city parameter to handle special characters and spaces
            String encodedCity = URLEncoder.encode(city, "UTF-8");
            String fullUrl = String.format("%s?q=%s&appid=%s", baseUrl, encodedCity, apiKey);
            // Check if the API is reachable
            if (isAPIReachable(fullUrl)) {
                return fullUrl;
            } else {
                System.out.println("API is down. Returning default city URL.");
                return String.format("%s?q=%s&appid=%s", baseUrl, URLEncoder.encode(defaultCity, "UTF-8"), apiKey);
            }
        } catch (UnsupportedEncodingException e) {
            // Handle the exception if encoding fails
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isAPIReachable(String fullUrl) {
        try {
            URL url = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            return (code == 200);
        } catch (IOException e) {
            // Handle exceptions related to network connectivity or API issues
            e.printStackTrace();
            return false;
        }
    }
}


