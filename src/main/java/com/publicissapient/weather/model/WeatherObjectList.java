package com.publicissapient.weather.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class WeatherObjectList.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public class WeatherObjectList {

    /** The dt. */
    private float dt;

    /** The main. */
    private Main main;

    /** The weather. */
    private List<WeatherDetail> weather = new ArrayList<WeatherDetail>();

    /** The clouds. */
    private Clouds clouds;

    /** The wind. */
    private Wind wind;

    /** The sys. */
    private Sys sys;

    /** The dt txt. */
    private String dt_txt;

    /**
     * Gets the dt.
     *
     * @return the dt
     */
    public float getDt() {
        return dt;
    }

    /**
     * Sets the dt.
     *
     * @param dt the dt to set
     */
    public void setDt(float dt) {
        this.dt = dt;
    }

    /**
     * Gets the weather.
     *
     * @return the mainObject
     */

    /**
     * @return the weather
     */
    public List<WeatherDetail> getWeather() {
        return weather;
    }

    /**
     * Sets the weather.
     *
     * @param weather the weather to set
     */
    public void setWeather(List<WeatherDetail> weather) {
        this.weather = weather;
    }

    /**
     * Gets the dt txt.
     *
     * @return the dt_txt
     */
    public String getDt_txt() {
        return dt_txt;
    }

    /**
     * Gets the main.
     *
     * @return the main
     */
    public Main getMain() {
        return main;
    }

    /**
     * Sets the main.
     *
     * @param main the main to set
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Gets the clouds.
     *
     * @return the clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * Sets the clouds.
     *
     * @param clouds the clouds to set
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * Gets the wind.
     *
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * Sets the wind.
     *
     * @param wind the wind to set
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * Gets the sys.
     *
     * @return the sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * Sets the sys.
     *
     * @param sys the sys to set
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * Sets the dt txt.
     *
     * @param dt_txt the dt_txt to set
     */
    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

}
