package com.publicissapient.weather.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.publicissapient.weather.model.Weather;

/**
 * The Interface IWeatherClient.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
@FeignClient(name = "openWeatherDataClient", url = "${feign.client.url}")
public interface IWeatherClient {

    /**
     * Gets the weather.
     *
     * @param q the city name
     * @return the weather
     */
    @RequestMapping(method = RequestMethod.GET)
    Weather getWeather(@RequestParam String q);

}
