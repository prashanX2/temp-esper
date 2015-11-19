package com.cor.cep.event;

import java.util.Date;

/**
 * Created by prashan on 10/25/15.
 */
public class WarnTempEvent {

    /** Temperature in Celcius. */
    private int warntemperature;

    /** Time temerature reading was taken. */
    private Date timeOfReading;

    /**priority of the event*/
    private int priority;

    private String ID = "WTEM";

    /**
     * Single value constructor.
     * @param value Temperature in Celsius.
     */
    /**
     * Temeratur constructor.
     * @param warntemperature Temperature in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public WarnTempEvent(int warntemperature, Date timeOfReading, int priority) {
        this.warntemperature = warntemperature;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
    }

    /**
     * Get the Temperature.
     * @return Temperature in Celsius
     */
    public int getwarntemperature() {
        return warntemperature;
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

    /**get ID*/
    public String getID(){return ID;}

    @Override
    public String toString() {
        return "Warning TemperatureEvent [" + warntemperature + "C  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
