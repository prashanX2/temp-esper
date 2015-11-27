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
    private long time;
    /**priority of the event*/
    private int priority;

    private String ID = "ATEM";

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
    public AvgTempEvent(int avgtemperature, Date timeOfReading, int priority, long time) {
        this.avgtemperature = avgtemperature;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
        this.time = time;
    }

    /**
     * Get the Temperature.
     * @return Temperature in Celsius
     */
    public int getavgtemperature() {
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


    /**get ID*/
    public String getID(){return ID;}

    /**get time*/
    public long getTime(){return time;}
    @Override
    public String toString() {
        return "AVG TemperatureEvent [" + avgtemperature + "C  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
