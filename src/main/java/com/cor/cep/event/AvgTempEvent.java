package com.cor.cep.event;

import java.util.Date;

/**
 * Created by prashan on 10/8/15.
 */
public class AvgTempEvent {

    /** Temperature in Celcius. */
    private int avgtemperature;

    /** Time temerature reading was taken. */
    private Date timeOfReading;

    /**
     * Single value constructor.
     * @param value Temperature in Celsius.
     */
    /**
     * Temeratur constructor.
     * @param avgtemperature Temperature in Celsius
     * @param timeOfReading Time of Reading
     */
    public AvgTempEvent(int avgtemperature, Date timeOfReading) {
        this.avgtemperature = avgtemperature;
        this.timeOfReading = timeOfReading;
    }

    /**
     * Get the Temperature.
     * @return Temperature in Celsius
     */
    public int getAvgTemperature() {
        return avgtemperature;
    }

    /**
     * Get time Temperature reading was taken.
     * @return Time of Reading
     */
    public Date getTimeOfReading() {
        return timeOfReading;
    }

    @Override
    public String toString() {
        return "AVG TemperatureEvent [" + avgtemperature + "C]";
    }

}
