package com.cor.cep.util;
/**
 * Created by prashan on 9/8/15.
 */
public final class IPCServer_H001 {


    String ID = "H001";
    static int luminous = 0;
    static float gravity_x = 0;
    //float gravity_y = 0;
    //float gravity_z = 0;
    static float azimuth = 0;

    public static void decodeStream(String[] decode)
    {
        //System.out.println(decode[1]+" "+decode[2]);

        luminous = (int)Float.parseFloat(decode[3]);
        //System.out.println(luminous);
    }

    public static int get(){return luminous;}

}

