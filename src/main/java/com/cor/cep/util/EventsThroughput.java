package com.cor.cep.util;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventsThroughput {

    public static int eventpersec =0;

    public void runEventThroughput()
    {
        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        xrayExecutor.submit(new Runnable() {
            public void run() {

                while(true)
                {
                    try {


                        eventpersec = EventPriorities.getEventCount();

                        EventPriorities.nullEventCount();

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



}
