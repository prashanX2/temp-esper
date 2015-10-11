package com.cor.cep.event;


import java.util.Date;

public class HumidityEvent {

    /** humidity % */
    private int humidity;

    /** Time humidity reading was taken. */
    private Date timeOfReading;

    /**
     * Single value constructor.
     * @param value humidity %.
     */
    /**
     * humidity constructor.
     * @param humidity %
     * @param timeOfReading Time of Reading
     */
    public HumidityEvent(int humidity, Date timeOfReading) {
        this.humidity = humidity;
        this.timeOfReading = timeOfReading;
    }

    /**
     * Get the humidity.
     * @return humidity %
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * Get time humidity reading was taken.
     * @return Time of Reading
     */
    public Date getTimeOfReading() {
        return timeOfReading;
    }

    @Override
    public String toString() {
        return "HumidityEvent [" + humidity + "%]";
    }

}
