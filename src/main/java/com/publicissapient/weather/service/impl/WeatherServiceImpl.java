/*******************************************************************************
 * Copyright 2020 rantidev.singh1@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package com.publicissapient.weather.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */


@Service
public class WeatherServiceImpl implements WeatherService {
    
    /** The logger. */
    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);

    /** The weather client. */
    @Autowired
    private IWeatherClient weatherClient;

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

        Weather cityWeather = weatherClient.getWeather(city);

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
