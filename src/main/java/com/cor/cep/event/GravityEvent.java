package com.cor.cep.event;


import java.util.Date;

public class GravityEvent {

    /** gravity in 3 axixs */
    private float gravityx;
    private float gravityy;
    private float gravityz;
    /** Time reading was taken. */
    private Date timeOfReading;


    /**priority of the event*/
    private int priority;
    /**
     * Single value constructor.
     * @param value gravity in axix.
     */
    /**
     * Temeratur constructor.
     * @param gravityx gravityeration in x axix
     * @param gravityy gravityeration in y axix
     * @param gravityz gravityeration in z axix
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public GravityEvent(float gravityx, float gravityy, float gravityz, Date timeOfReading, int priority) {
        this.gravityx = gravityx;
        this.gravityy = gravityy;
        this.gravityz = gravityz;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
    }

    /**
     * Get all gravity.
     * @return gravity in x axix
     */
    public float getgravityx() {
        return gravityx;
    }

    /**
     * Get all gravity.
     * @return gravity in y axix
     */
    public float getgravityy() {
        return gravityy;
    }

    /**
     * Get all gravity.
     * @return gravity in z axix
     */
    public float getgravityz() {
        return gravityz;
    }



    /**
     * Get time gravity reading was taken.
     * @return Time of Reading
     */
    public Date getTimeOfReading() {
        return timeOfReading;
    }

    /**get priority*/
    public int getPriority(){return priority;}

    @Override
    public String toString() {
        return "gravityEvent [ X:" + gravityx + " Y:"+gravityy+" Z:"+gravityz+" ]  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }
    
    
}
