package com.cor.cep.event;
import java.util.Date;

public class LuminousEvent {

    private String ID = "LUMI";
    /** luminous in Celcius. */
    private int luminous;

    /** Time luminous reading was taken. */
    private Date timeOfReading;

    /**priority of the event*/
    private int priority;

    /**
     * Single value constructor.
     * @param value luminous in Celsius.
     */
    /**
     * Luminous constructor.
     * @param luminous luminous in Celsius
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public LuminousEvent(int luminous, Date timeOfReading, int priority) {
        this.luminous = luminous;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
    }

    /**
     * Get the luminous.
     * @return luminous in Celsius
     */
    public int getluminous() {
        return luminous;
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

    @Override
    public String toString() {
        return "luminousEvent [" + luminous + "C]  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }
    
}
