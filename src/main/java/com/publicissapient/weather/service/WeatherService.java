package com.publicissapient.weather.service;

import java.util.List;
import com.publicissapient.weather.model.WeatherForecast;

/**
 * The Interface WeatherService represents the service layer for diff api.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public interface WeatherService {

    List<WeatherForecast> getCityWeather(String city);

}
