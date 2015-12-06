package com.cor.cep.util;


import com.cor.cep.event.WarnHumiEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventsThroughput {


    public static int maxEventsPerSec = 10000;

    public static int eventpersec =0;

    /**primitive events */
    public static int accelcount = 0;
    public static int gravitycount = 0;
    public static int rotationcount = 0;
    public static int orientationcount = 0;
    public static int lumicount = 0;


    public static int tempcount = 0;
    public static int humiditycount = 0;

    public static int distancecount = 0;










    /**Secondory events*/


    public static int AVGtempcount = 0;
    public static int AVGlumicount = 0;
    public static int AVGhumicount = 0;


    public static int warntempcount = 0;
    public static int warnlumicount = 0;
    public static int warnhumicount = 0;

    public static int entered = 0;





    public void runEventThroughput()
    {
        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        xrayExecutor.submit(new Runnable() {
            public void run() {

                while(true)
                {
                    try {

                        //System.out.println(accelcount+" "+humiditycount);
                        eventpersec = EventsThroughput.totalEventcount();
                        LogData.eventthroughputWrite(Integer.toString(eventpersec), System.nanoTime() - ResultReciever.systemStartTime);

                        LogData.primaryeventthroughputWrite(Integer.toString(accelcount+gravitycount+rotationcount+orientationcount+lumicount+distancecount+tempcount+humiditycount), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.secondaryeventthroughputWrite(Integer.toString(AVGtempcount+AVGhumicount+AVGlumicount+warntempcount+warnhumicount+warnlumicount+entered), System.nanoTime() - ResultReciever.systemStartTime );
                        //LogData.tiertaryeventthroughputWrite(Integer.toString(eventpersec), System.nanoTime() - ResultReciever.systemStartTime );

                        EventsThroughput.nullAlleventcount();

                        System.out.println("EVENTS PER SEC "+eventpersec);

                        Thread.sleep(1000);
                    }
                    catch(Exception th)
                    {
                        System.out.println(th);
                    }

                }


            }
        });
    }



    public static int  totalEventcount()
    {
        return accelcount+gravitycount+rotationcount+orientationcount+lumicount+tempcount+humiditycount+distancecount+AVGlumicount+AVGtempcount+AVGhumicount+entered+warnlumicount+warntempcount+warnhumicount;

    }

    public static void nullAlleventcount()
    {
        accelcount = 0;
        gravitycount = 0;
        rotationcount = 0;
        orientationcount = 0;
        lumicount = 0;


        tempcount = 0;
        humiditycount = 0;

        distancecount = 0;




        AVGtempcount = 0;
        AVGlumicount = 0;
        AVGhumicount = 0;

        warnlumicount = 0;
        warntempcount = 0;
        warnhumicount = 0;

        entered = 0;



    }




}
