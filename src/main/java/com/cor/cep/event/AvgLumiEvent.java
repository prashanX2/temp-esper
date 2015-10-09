package com.cor.cep.event;

import java.util.Date;


public class AvgLumiEvent {

    /** luminous in Celcius. */
    private int avgluminous;

    /** Time luminous reading was taken. */
    private Date timeOfReading;

    /**
     * Single value constructor.
     * @param value luminous in Celsius.
     */
    /**
     * Luminous constructor.
     * @param avgluminous luminous in Celsius
     * @param timeOfReading Time of Reading
     */
    public AvgLumiEvent(int avgluminous, Date timeOfReading) {
        this.avgluminous = avgluminous;
        this.timeOfReading = timeOfReading;
    }

    /**
     * Get the luminous.
     * @return luminous in Celsius
     */
    public int getavgluminous() {
        return avgluminous;
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
        return "AVG luminousEvent [" + avgluminous + "C]";
    }

}
