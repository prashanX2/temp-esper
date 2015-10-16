package com.cor.cep.event;
import java.util.Date;

public class AccelerationEvent {


    /** acceleration in 3 axixs */
    private float accelx;
    private float accely;
    private float accelz;
    /** Time reading was taken. */
    private Date timeOfReading;

    /**priority of the event*/
    private int priority;

    /**
     * Single value constructor.
     * @param value acceleration in axix.
     */
    /**
     * Temeratur constructor.
     * @param accelx acceleration in x axix
     * @param accely acceleration in y axix
     * @param accelz acceleration in z axix
     * @param timeOfReading Time of Reading
     * @param priority priority of the event
     */
    public AccelerationEvent(float accelx, float accely, float accelz, Date timeOfReading, int priority) {
        this.accelx = accelx;
        this.accely = accely;
        this.accelz = accelz;
        this.timeOfReading = timeOfReading;
        this.priority = priority;
    }

    /**
     * Get all accel.
     * @return accel in x axix
     */
    public float getAccelx() {
        return accelx;
    }

    /**
     * Get all accel.
     * @return accel in y axix
     */
    public float getAccely() {
        return accely;
    }

    /**
     * Get all accel.
     * @return accel in z axix
     */
    public float getAccelz() {
        return accelz;
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
        return "AccelerationEvent [ X:" + accelx + " Y:"+accely+" Z:"+accelz+" ]  TimeStamp: "+timeOfReading+" Priority: "+priority;
    }



}
