package com.cor.cep.util;


public final class IPCServer_SD01 {

    String ID = "SD01";
    static int distance = 0;


    public static void decodeStream(String[] decode)
    {
        distance = ((int)Float.parseFloat(decode[1]));

    }

    public static int getDistance(){return distance;}




}
