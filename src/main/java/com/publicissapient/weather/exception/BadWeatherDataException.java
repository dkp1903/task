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
package com.publicissapient.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class WeatherDataException.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadWeatherDataException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new bad weather data exception.
     *
     * @param message the message
     */
    public BadWeatherDataException(String message) {
        super(message);
    }

    /**
     * Instantiates a new bad weather data exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BadWeatherDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
