package com.cor.cep.event;

import java.util.Date;


public class EnteredEvent {


    private int distance1;
    private int distance2;



    private Date timeOfReading;

    /**priority of the event*/
    private int priority;



    public EnteredEvent(int distance1,int distance2, Date timeOfReading, int priority) {
        this.distance1 = distance1;
        this.distance2 = distance2;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
    }

    /**
     * Get the luminous.
     * @return luminous in Celsius
     */
    public int getDistance1() {
        return distance1;
    }

    public int getDistance2() {
        return distance2;
    }

    /**
     * Get time Temperature reading was taken.
     * @return Time of Reading
     */
    public Date getTimeOfReading() {
        return timeOfReading;
    }


    /**get priority*/
    public int getPriority(){return priority;}

    @Override
    public String toString() {
        return "Entered Event [Distance1 " + distance1 + " Distance2 "+distance2+"  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }

}
