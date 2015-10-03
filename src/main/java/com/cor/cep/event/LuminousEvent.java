package com.cor.cep.event;
import java.util.Date;

public class LuminousEvent {

    /** luminous in Celcius. */
    private int luminous;

    /** Time luminous reading was taken. */
    private Date timeOfReading;

    /**
     * Single value constructor.
     * @param value luminous in Celsius.
     */
    /**
     * Luminous constructor.
     * @param luminous luminous in Celsius
     * @param timeOfReading Time of Reading
     */
    public LuminousEvent(int luminous, Date timeOfReading) {
        this.luminous = luminous;
        this.timeOfReading = timeOfReading;
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

    @Override
    public String toString() {
        return "luminousEvent [" + luminous + "C]";
    }
    
}
