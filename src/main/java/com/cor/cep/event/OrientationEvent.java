package com.cor.cep.event;


import java.util.Date;

public class OrientationEvent {

    /** acceleration in 3 axixs */
    private float azimuth;
    private float pitch;
    private float roll;
    /** Time reading was taken. */
    private Date timeOfReading;

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
     */
    public OrientationEvent(float azimuth, float pitch, float roll, Date timeOfReading) {
        this.azimuth = azimuth;
        this.pitch = pitch;
        this.roll = roll;
        this.timeOfReading = timeOfReading;
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

    @Override
    public String toString() {
        return "OrientationEvent [ Azimuth:" + azimuth + " Pitch:"+pitch+" Roll:"+roll+" ]";
    }
    
}
