
package com.publicissapient.weather.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.weather.exception.ResourceNotFoundException;
import com.publicissapient.weather.model.WeatherForecast;
import com.publicissapient.weather.service.WeatherService;
import com.publicissapient.weather.util.Constants;

/**
 * The Class WeatherController.
 * 

 */
@RestController()
@RequestMapping("/v1/weather")
public class WeatherController {

    /** The logger. */
    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    /**
     * end-point to get weather forecast of a city for next three days.
     * 
     * This end-point retrieves the weather forecast by {city} from OpenWeatherMap
     * Api and then checks for city temperature and weather condition.
     *
     * @param city the city for which weather forecast is needed.
     * @return the list of WeatherForecast
     * @see com.publicissapient.weather.model.WeatherForecast
     */
    @GetMapping("/{city}")
    public ResponseEntity<List<WeatherForecast>> getWeatherByCity
                                    (@PathVariable String city) {
        LOG.trace("Entering getWeatherByCity(city={})", city);

        if (city == null || city.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<List<WeatherForecast>>(
                    weatherService.getCityWeather(city), HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResourceNotFoundException(Constants.WEATHER_NOT_FOUND + city);
        }
    }

}
