package com.publicissapient.weather.model;

/**
 * The Class City.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public class City {

    /** The id. */
    private float id;

    /** The name. */
    private String name;

    /** The coord. */
    private Coord coord;

    /** The country. */
    private String country;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public float getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(float id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the coord.
     *
     * @return the coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Sets the coord.
     *
     * @param coord the coord to set
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

}
