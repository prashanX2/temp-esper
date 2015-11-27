package com.cor.cep.event;

import java.util.Date;

/**
 * Immutable Temperature Event class. The process control system creates these events. The
 * TemperatureEventHandler picks these up and processes them.
 */
public class TemperatureEvent {

    /** Temperature in Celcius. */
    private int temperature;
    
    /** Time temerature reading was taken. */
    private Date timeOfReading;
    private long time;
    /**priority of the event*/
    private int priority;

    private String ID = "TEMP";
    
    /**
     * Single value constructor.
     * @param value Temperature in Celsius.
     */
    /**
     * Temeratur constructor.
     * @param temperature Temperature in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public TemperatureEvent(int temperature, Date timeOfReading, int priority, long time) {
        this.temperature = temperature;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
        this.time = time;
    }

    /**
     * Get the Temperature.
     * @return Temperature in Celsius
     */
    public int getTemperature() {
        return temperature;
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
        return "TemperatureEvent [" + temperature + "C]  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
