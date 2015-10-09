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



        luminous = (int)Float.parseFloat(decode[13]);
        azimuth = Math.abs((int)Float.parseFloat(decode[10]));
        //System.out.println(luminous);
    }



    public static float accelx(){return accelx;}

    public static float accely(){return accely;}

    public static float accelz(){return accelz;}



    public static float gravityx(){return gravityx;}

    public static float gravityy(){return gravityy;}

    public static float gravityz(){return gravityz;}


    public static float rotationx(){return rotationx;}

    public static float rotationy(){return rotationy;}

    public static float rotationz(){return rotationz;}



    public static int getazi(){return azimuth;}

    public static int getpitch(){return pitch;}

    public static int getroll(){return roll;}



    public static int getlumi(){return luminous;}

}

