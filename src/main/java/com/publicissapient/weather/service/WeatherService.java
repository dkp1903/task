package com.publicissapient.weather.service;

import java.util.List;
import com.publicissapient.weather.model.WeatherForecast;

/**
 * The Interface WeatherService represents the service layer for diff api.
 * 

 */
public interface WeatherService {

    List<WeatherForecast> getCityWeather(String city);

}
