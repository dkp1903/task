package com.publicissapient.weather.model;

/**
 * The Class Wind.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public class Wind {

    /** The speed. */
    private float speed;

    /** The deg. */
    private float deg;

    // Getter Methods

    /**
     * Gets the speed.
     *
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Gets the deg.
     *
     * @return the deg
     */
    public float getDeg() {
        return deg;
    }

    // Setter Methods

    /**
     * Sets the speed.
     *
     * @param speed the new speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Sets the deg.
     *
     * @param deg the new deg
     */
    public void setDeg(float deg) {
        this.deg = deg;
    }
}
