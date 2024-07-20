package com.publicissapient.weather.model;

/**
 * The Class WeatherDetail.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2021-04-18
 */
public class WeatherDetail {

    /** The id. */
    private float id;

    /** The main. */
    private String main;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    // Getter Methods

    /**
     * Gets the id.
     *
     * @return the id
     */
    public float getId() {
        return id;
    }

    /**
     * Gets the main.
     *
     * @return the main
     */
    public String getMain() {
        return main;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the icon.
     *
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    // Setter Methods

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(float id) {
        this.id = id;
    }

    /**
     * Sets the main.
     *
     * @param main the new main
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the icon.
     *
     * @param icon the new icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
