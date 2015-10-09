package com.cor.cep.event;


import java.util.Date;

public class RotationEvent {

    /** rotationeration in 3 axixs */
    private float rotationx;
    private float rotationy;
    private float rotationz;
    /** Time reading was taken. */
    private Date timeOfReading;

    /**
     * Single value constructor.
     * @param value rotation in axix.
     */
    /**
     * Temeratur constructor.
     * @param rotationx rotation in x axix
     * @param rotationy rotation in y axix
     * @param rotationz rotation in z axix
     * @param timeOfReading Time of Reading
     */
    public RotationEvent(float rotationx, float rotationy, float rotationz, Date timeOfReading) {
        this.rotationx = rotationx;
        this.rotationy = rotationy;
        this.rotationz = rotationz;
        this.timeOfReading = timeOfReading;
    }

    /**
     * Get all rotation.
     * @return rotation in x axix
     */
    public float getrotationx() {
        return rotationx;
    }

    /**
     * Get all rotation.
     * @return rotation in y axix
     */
    public float getrotationy() {
        return rotationy;
    }

    /**
     * Get all rotation.
     * @return rotation in z axix
     */
    public float getrotationz() {
        return rotationz;
    }



    /**
     * Get time rotation reading was taken.
     * @return Time of Reading
     */
    public Date getTimeOfReading() {
        return timeOfReading;
    }

    @Override
    public String toString() {
        return "rotationEvent [ X:" + rotationx + " Y:"+rotationy+" Z:"+rotationz+" ]";
    }
    
}
