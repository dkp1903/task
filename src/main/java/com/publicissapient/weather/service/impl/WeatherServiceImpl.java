
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
        weatherUrl = "https://samples.openweathermap.org/data/2.5/forecast?q=&appid=d2929e9483efc82c82c32ee7e02d563e";
        // Weather cityWeather = weatherClient.getWeather(city);
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

}
