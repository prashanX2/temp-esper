package com.cor.cep.event;


import java.util.Date;

public class OrientationEvent {

    /** acceleration in 3 axixs */
    private float azimuth;
    private float pitch;
    private float roll;
    /** Time reading was taken. */
    private Date timeOfReading;

    /**priority of the event*/
    private int priority;

    private String ID = "ORIE";

    /**
     * Single value constructor.
     * @param value acceleration in axix.
     */
    /**
     * Temeratur constructor.
     * @param azimuth acceleration in x axix
     * @param pitch acceleration in y axix
     * @param roll acceleration in z axix
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public OrientationEvent(float azimuth, float pitch, float roll, Date timeOfReading, int priority) {
        this.azimuth = azimuth;
        this.pitch = pitch;
        this.roll = roll;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
    }

    /**
     *
     * @return azimuth
     */
    public float getazimuth() {
        return azimuth;
    }

    /**
     *
     * @return pitch
     */
    public float getpitch() {
        return pitch;
    }

    /**
     *
     * @return roll
     */
    public float getroll() {
        return roll;
    }



    /**
     * Get time orientation reading was taken.
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
        return "OrientationEvent [ Azimuth:" + azimuth + " Pitch:"+pitch+" Roll:"+roll+"   TimeStamp: "+timeOfReading+" Priority: "+priority;
    }
    
}
