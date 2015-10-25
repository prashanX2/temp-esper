package com.cor.cep.event;


import java.util.Date;

public class AvgHumiEvent {

    /** humidity in Celcius. */
    private int avghumidity;

    /** Time humidity reading was taken. */
    private Date timeOfReading;

    /**priority of the event*/
    private int priority;

    /**
     * Single value constructor.
     * @param value humidity in Celsius.
     */
    /**
     * humidity constructor.
     * @param avghumidity humidity in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public AvgHumiEvent(int avghumidity, Date timeOfReading, int priority) {
        this.avghumidity = avghumidity;
        this.timeOfReading = timeOfReading;
        this.priority = priority;

    }

    /**
     * Get the humidity.
     * @return humidity in Celsius
     */
    public int getavghumidity()  {
        return avghumidity;
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

    @Override
    public String toString() {
        return "AVG humidity [" +avghumidity + "%  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
