package com.cor.cep.event;


import java.util.Date;

public class WarnLumiEvent {
    /** luminous in Celcius. */
    private int warnluminous;

    /** Time luminous reading was taken. */
    private Date timeOfReading;
    private long time;
    /**priority of the event*/
    private int priority;


    private String ID = "WLUM";
    /**
     * Single value constructor.
     * @param value luminous in Celsius.
     */
    /**
     * Luminous constructor.
     * @param warnluminous luminous in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public WarnLumiEvent(int warnluminous, Date timeOfReading, int priority, long time) {
        this.warnluminous = warnluminous;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
        this.time = time;
    }

    /**
     * Get the luminous.
     * @return luminous in Celsius
     */
    public int getwarnluminous()  {
        return warnluminous;
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
        return "Warning luminousEvent [" + warnluminous + "C  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}


