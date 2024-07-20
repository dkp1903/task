package com.publicissapient.weather.model;

/**
 * The Class WeatherForecast.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public class WeatherForecast {

    /** The high. */
    private float high;

    /** The low. */
    private float low;

    /** The message. */
    private String message;

    /**
     * Gets the high.
     *
     * @return the high
     */
    public float getHigh() {
        return high;
    }

    /**
     * Sets the high.
     *
     * @param high the high to set
     */
    public void setHigh(float high) {
        this.high = high;
    }

    /**
     * Gets the low.
     *
     * @return the low
     */
    public float getLow() {
        return low;
    }

    /**
     * Sets the low.
     *
     * @param low the low to set
     */
    public void setLow(float low) {
        this.low = low;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
