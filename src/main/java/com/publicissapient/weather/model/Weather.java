package com.publicissapient.weather.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Weather.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public class Weather {

    /** The cod. */
    private String cod;

    /** The message. */
    private float message;

    /** The cnt. */
    private float cnt;

    /** The list. */
    private List<WeatherObjectList> list = new ArrayList<WeatherObjectList>();

    /** The City object. */
    private City CityObject;

    /**
     * Gets the cod.
     *
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * Sets the cod.
     *
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public float getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the message to set
     */
    public void setMessage(float message) {
        this.message = message;
    }

    /**
     * Gets the cnt.
     *
     * @return the cnt
     */
    public float getCnt() {
        return cnt;
    }

    /**
     * Sets the cnt.
     *
     * @param cnt the cnt to set
     */
    public void setCnt(float cnt) {
        this.cnt = cnt;
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<WeatherObjectList> getList() {
        return list;
    }

    /**
     * Sets the list.
     *
     * @param list the list to set
     */
    public void setList(List<WeatherObjectList> list) {
        this.list = list;
    }

    /**
     * Gets the city object.
     *
     * @return the cityObject
     */
    public City getCityObject() {
        return CityObject;
    }

    /**
     * Sets the city object.
     *
     * @param cityObject the cityObject to set
     */
    public void setCityObject(City cityObject) {
        CityObject = cityObject;
    }

}
