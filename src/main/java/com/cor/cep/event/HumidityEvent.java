package com.cor.cep.event;


import java.util.Date;

public class HumidityEvent {

    /** humidity % */
    private int humidity;

    /** Time humidity reading was taken. */
    private Date timeOfReading;
    private long time;
    /**priority of the event*/
    private int priority;

    private String ID = "HUMI";

    /**
     * Single value constructor.
     * @param value humidity %.
     */
    /**
     * humidity constructor.
     * @param humidity %
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public HumidityEvent(int humidity, Date timeOfReading, int priority, long time) {
        this.humidity = humidity;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
        this.time = time;
    }

    /**
     * Get the humidity.
     * @return humidity %
     */
    public int gethumidity() {
        return humidity;
    }

    /**
     * Get time humidity reading was taken.
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
        return "HumidityEvent [" + humidity + "%]  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
