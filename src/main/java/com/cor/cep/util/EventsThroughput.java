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


    /**teirtary events*/

    public static int distlumicount = 0;
    public static int disttempcount = 0;
    public static int distwarntempcount = 0;



    /**schedule monitor*/

    public static int localevent = 0;
    public static int cloudevent = 0;

    public static int caccelcount = 0;
    public static int cgravitycount = 0;
    public static int crotationcount = 0;
    public static int corientationcount = 0;
    public static int clumicount = 0;


    public static int ctempcount = 0;
    public static int chumiditycount = 0;

    public static int cdistancecount = 0;




    public static int cAVGtempcount = 0;
    public static int cAVGlumicount = 0;
    public static int cAVGhumicount = 0;


    public static int cwarntempcount = 0;
    public static int cwarnlumicount = 0;
    public static int cwarnhumicount = 0;

    public static int centered = 0;




    public static int laccelcount = 0;
    public static int lgravitycount = 0;
    public static int lrotationcount = 0;
    public static int lorientationcount = 0;
    public static int llumicount = 0;


    public static int ltempcount = 0;
    public static int lhumiditycount = 0;

    public static int ldistancecount = 0;




    public static int lAVGtempcount = 0;
    public static int lAVGlumicount = 0;
    public static int lAVGhumicount = 0;


    public static int lwarntempcount = 0;
    public static int lwarnlumicount = 0;
    public static int lwarnhumicount = 0;

    public static int lentered = 0;

    public static int ldistlumicount = 0;
    public static int ldisttempcount = 0;
    public static int ldistwarntempcount = 0;

    public static int cdistlumicount = 0;
    public static int cdisttempcount = 0;
    public static int cdistwarntempcount = 0;





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

                        LogData.primaryeventthroughputWrite(Integer.toString(accelcount + gravitycount + rotationcount + orientationcount + lumicount + distancecount + tempcount + humiditycount), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.secondaryeventthroughputWrite(Integer.toString(AVGtempcount + AVGhumicount + AVGlumicount + warntempcount + warnhumicount + warnlumicount + entered), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.tiertaryeventthroughputWrite(Integer.toString(distlumicount + disttempcount + distwarntempcount), System.nanoTime() - ResultReciever.systemStartTime);

                        LogData.localeventWrite(Integer.toString(localevent), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.cloudeventWrite(Integer.toString(cloudevent), System.nanoTime() - ResultReciever.systemStartTime);

                        LogData.lprimaryeventWrite(Integer.toString(laccelcount + lgravitycount + lrotationcount + lorientationcount + llumicount + ldistancecount + ltempcount + lhumiditycount), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.cprimaryeventWrite(Integer.toString(caccelcount + cgravitycount + crotationcount + corientationcount + clumicount + cdistancecount + ctempcount + chumiditycount), System.nanoTime() - ResultReciever.systemStartTime);

                        LogData.lcriticaleventWrite(Integer.toString(lwarntempcount + lwarnhumicount + lwarnlumicount + ldistwarntempcount), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.ccriticaleventWrite(Integer.toString(cwarntempcount + cwarnhumicount + cwarnlumicount + cdistwarntempcount), System.nanoTime() - ResultReciever.systemStartTime);

                        LogData.lnormaleventWrite(Integer.toString(lAVGtempcount + lAVGhumicount + lAVGlumicount), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.cnormaleventWrite(Integer.toString(cAVGtempcount + cAVGhumicount + cAVGlumicount), System.nanoTime() - ResultReciever.systemStartTime);


                        LogData.lnoncriticaleventWrite(Integer.toString(lentered + ldistlumicount + ldistlumicount), System.nanoTime() - ResultReciever.systemStartTime);
                        LogData.cnoncriticaleventWrite(Integer.toString(centered + cdistlumicount + cdistlumicount), System.nanoTime() - ResultReciever.systemStartTime);


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

        distlumicount = 0;
        disttempcount = 0;
        distwarntempcount = 0;

        localevent = 0;
        cloudevent = 0;


        caccelcount = 0;
        cgravitycount = 0;
       crotationcount = 0;
        corientationcount = 0;
         clumicount = 0;


      ctempcount = 0;
       chumiditycount = 0;

        cdistancecount = 0;




       cAVGtempcount = 0;
        cAVGlumicount = 0;
        cAVGhumicount = 0;


        cwarntempcount = 0;
        cwarnlumicount = 0;
         cwarnhumicount = 0;

       centered = 0;


        laccelcount = 0;
        lgravitycount = 0;
        lrotationcount = 0;
        lorientationcount = 0;
        llumicount = 0;


        ltempcount = 0;
        lhumiditycount = 0;

        ldistancecount = 0;




        lAVGtempcount = 0;
        lAVGlumicount = 0;
        lAVGhumicount = 0;


        lwarntempcount = 0;
        lwarnlumicount = 0;
        lwarnhumicount = 0;

        lentered = 0;


        ldistlumicount = 0;
        ldisttempcount = 0;
       ldistwarntempcount = 0;

       cdistlumicount = 0;
      cdisttempcount = 0;
        cdistwarntempcount = 0;





    }




}
