package com.cor.cep.event;

import java.util.Date;


public class AvgLumiEvent {

    /** luminous in Celcius. */
    private int avgluminous;

    /** Time luminous reading was taken. */
    private Date timeOfReading;
    private long time;
    /**priority of the event*/
    private int priority;

    private String ID = "ALUM";

    /**
     * Single value constructor.
     * @param value luminous in Celsius.
     */
    /**
     * Luminous constructor.
     * @param avgluminous luminous in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public AvgLumiEvent(int avgluminous, Date timeOfReading, int priority, long time) {
        this.avgluminous = avgluminous;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
        this.time = time;

    }

    /**
     * Get the luminous.
     * @return luminous in Celsius
     */
    public int getavgluminous()  {
         return avgluminous;
    }

    /**
     * Get time luminous reading was taken.
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
        return "AVG luminousEvent [" + avgluminous + " Lux  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
