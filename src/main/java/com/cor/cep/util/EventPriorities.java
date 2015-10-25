package com.cor.cep.util;

public final class EventPriorities {

    private static int acceleration = 3;
    private static int gravity = 3;
    private static int rotation = 3;
    private static int orientation = 3;
    private static int luminous = 3;


    private static int temperature = 3;
    private static int humidity = 3;

    private static int distance = 3;

    /**secondory Event priorities*/

    private static int entered = 3;

    private static int avgtemp = 3;
    private static int avglumi = 3;
    private static int avghumi = 3;

    private static int warntemp = 3;
    private static int warnlumi = 3;
    private static int warnhumi = 3;



    private static int eventCount;


    public static int getAccelP(){return acceleration;}
    public static int getGravityP(){return gravity;}
    public static int getRotationP(){return rotation;}
    public static int getOrientationP(){return orientation;}
    public static int getLuminousP(){return luminous;}



    public static int getTemperatureP(){return temperature;}

    public static int getHumidityP(){return humidity;}

    public static int getDistanceP(){return distance;}

    public static void eventCountadd(){eventCount++;}

    public static int getEventCount(){return eventCount;}

    public static void nullEventCount(){eventCount = 0;}




    /**secondary event getters*/

    public static int getentered(){return entered;}


    public static int getavglumi(){return avglumi;}
    public static int getavgtemp(){return avgtemp;}
    public static int getavghumi(){return avghumi;}

    public static int getwarntemp(){return warntemp;}
    public static int getwarnlumi(){return warnlumi;}
    public static int getwarnhumi(){return warnhumi;}












}
