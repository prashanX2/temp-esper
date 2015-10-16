package com.cor.cep.event;


import java.util.Date;

public class DistanceEvent {

    /** distance cm */
    private int distance;

    /** Time distance reading was taken. */
    private Date timeOfReading;


    /**priority of the event*/
    private int priority;
    /**
     * Single value constructor.
     * @param value distance %.
     */
    /**
     * distance constructor.
     * @param distance cm
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public DistanceEvent(int distance, Date timeOfReading, int priority) {
        this.distance = distance;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
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

    /**get priority*/
    public int getPriority(){return priority;}

    @Override
    public String toString() {
        return "distanceEvent [" + distance + "cm]  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }
    
}
