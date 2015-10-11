package com.cor.cep.util;


public final class IPCServer_STH1 {

    String ID = "STH1";
    static int temperature = 0;
    static int humidity = 0;


    public static void decodeStream(String[] decode)
    {
        temperature = ((int)Float.parseFloat(decode[1]));
        humidity = ((int)Float.parseFloat(decode[2]));

    }

    public static int getTemp(){return temperature;}

    public static int getHumidity(){return humidity;}




}
