package com.cor.cep.event;


import java.util.Date;

public class DistanceEvent {

    /** distance cm */
    private int distance;

    /** Time distance reading was taken. */
    private Date timeOfReading;

    /**
     * Single value constructor.
     * @param value distance %.
     */
    /**
     * distance constructor.
     * @param distance cm
     * @param timeOfReading Time of Reading
     */
    public DistanceEvent(int distance, Date timeOfReading) {
        this.distance = distance;
        this.timeOfReading = timeOfReading;
    }

    /**
     * Get the distance.
     * @return distance cm
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Get time distance reading was taken.
     * @return Time of Reading
     */
    public Date getTimeOfReading() {
        return timeOfReading;
    }

    @Override
    public String toString() {
        return "distanceEvent [" + distance + "cm]";
    }
    
}
