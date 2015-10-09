package com.cor.cep.util;

public final class IPCServer_H001 {


    String ID = "H001";

    static float accelx =0;
    static float accely =0;
    static float accelz =0;

    static float gravityx =0;
    static float gravityy =0;
    static float gravityz =0;


    static float rotationx =0;
    static float rotationy =0;
    static float rotationz =0;

    static int azimuth = 0;
    static int pitch = 0;
    static int roll = 0;

    static int luminous = 0;

    //float gravity_y = 0;
    //float gravity_z = 0;


    public static void decodeStream(String[] decode)
    {
        //System.out.println(decode[1]+" "+decode[2]);

        accelx = Float.parseFloat(decode[1]);
        accely = Float.parseFloat(decode[2]);
        accelz = Float.parseFloat(decode[3]);

        gravityx = Float.parseFloat(decode[4]);
        gravityy = Float.parseFloat(decode[5]);
        gravityz = Float.parseFloat(decode[6]);

        rotationx = Float.parseFloat(decode[7]);
        rotationy = Float.parseFloat(decode[8]);
        rotationz = Float.parseFloat(decode[9]);

        //azimuth = Math.abs((int) Float.parseFloat(decode[10]));
        pitch = ((int)Float.parseFloat(decode[11]));
        roll = ((int)Float.parseFloat(decode[12]));



        luminous = (int)Float.parseFloat(decode[13]);
        azimuth = Math.abs((int)Float.parseFloat(decode[10]));



        //System.out.println(luminous);
    }



    public static float getaccelx(){return accelx;}

    public static float getaccely(){return accely;}

    public static float getaccelz(){return accelz;}



    public static float getgravityx(){return gravityx;}

    public static float getgravityy(){return gravityy;}

    public static float getgravityz(){return gravityz;}


    public static float getrotationx(){return rotationx;}

    public static float getrotationy(){return rotationy;}

    public static float getrotationz(){return rotationz;}



    public static int getazi(){return azimuth;}

    public static int getpitch(){return pitch;}

    public static int getroll(){return roll;}



    public static int getlumi(){return luminous;}

}

