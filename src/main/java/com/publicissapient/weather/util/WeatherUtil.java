package com.publicissapient.weather.util;


/**
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 *
 */

public class WeatherUtil {

    /**
     * Converts temp to celsius.
     *
     * @param temp the temp
     * @return the float
     */
    public static float convertTempToCelsius(float temp) {
            return temp - 273.15F;
    }

}
