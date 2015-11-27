package com.cor.cep.event;

import java.util.Date;

public class WarnHumiEvent {

    /** humidity in Celcius. */
    private int warnhumidity;

    /** Time humidity reading was taken. */
    private Date timeOfReading;
    private long time;
    /**priority of the event*/
    private int priority;

    private String ID = "WHUM";

    /**
     * Single value constructor.
     * @param value humidity in Celsius.
     */
    /**
     * humidity constructor.
     * @param warnhumidity humidity in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public WarnHumiEvent(int warnhumidity, Date timeOfReading, int priority, long time) {
        this.warnhumidity = warnhumidity;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
        this.time = time;
    }

    /**
     * Get the humidity.
     * @return humidity in Celsius
     */
    public int getwarnhumidity()  {
        return warnhumidity;
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
        return "Warning humidityEvent [" + warnhumidity + "C  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }


}
