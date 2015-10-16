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

    /**priority of the event*/
    private int priority;

    /**
     * Single value constructor.
     * @param value Temperature in Celsius.
     */
    /**
     * Temeratur constructor.
     * @param avgtemperature Temperature in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public AvgTempEvent(int avgtemperature, Date timeOfReading, int priority) {
        this.avgtemperature = avgtemperature;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
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


    /**get priority*/
    public int getPriority(){return priority;}

    @Override
    public String toString() {
        return "AVG TemperatureEvent [" + avgtemperature + "C  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
