package com.cor.cep.util;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Predict {


    public static int platency = 0;
    public static int pdownload = 0;
    public static int pcputhroughput = 0;
    public static int peventspersec = 0;

    public static int predictdistance = 5;



    public static Queue<Double> latencyQueue = new LinkedList<Double>();
    public static Queue<Double> downloadQueue = new LinkedList<Double>();
    public static Queue<Double> cputhroughputQueue = new LinkedList<Double>();
    public static Queue<Double> eventspersecQueue = new LinkedList<Double>();


    public static void initPredict()
    {
        ExecutorService initexecutor = Executors.newSingleThreadExecutor();

        initexecutor.submit(new Runnable() {
            public void run() {

                try {
                    Thread.sleep(4000); // sleep for 10 sec
                    System.out.println("****************** FILLING QUEUES STARTED");
                    fillQueues();


                }catch(Exception e){System.out.println(e.toString());}


            }
        });
    }




    public static void fillQueues()
    {

        final int historysize = 20;


        ExecutorService fillQueueexecutor = Executors.newSingleThreadExecutor();

        fillQueueexecutor.submit(new Runnable() {
            public void run() {

                while(true) {
                    try
                    {

                        latencyQueue.add(Double.valueOf(NetworkLatency.latency));
                        downloadQueue.add(Double.valueOf(NetworkThroughput.download));
                        cputhroughputQueue.add(Double.valueOf(CpuThroughput.cpuLoad));
                        eventspersecQueue.add(Double.valueOf(EventsThroughput.eventpersec));



                        if(latencyQueue.size() >= historysize)
                        {
                            //System.out.println(latencyQueue.size());
                            platency = predictonQueues(latencyQueue, "latency",2);
                            LogData.platencyWrite(Long.toString(platency), (System.nanoTime() - ResultReciever.systemStartTime)+(predictdistance*1000));

                            platency = predictonQueues(latencyQueue, "latency",3);
                            LogData.p3latencyWrite(Long.toString(platency), (System.nanoTime() - ResultReciever.systemStartTime) + (predictdistance * 1000));

                            platency = predictonQueues(latencyQueue, "latency",4);
                            LogData.p4latencyWrite(Long.toString(platency), (System.nanoTime() - ResultReciever.systemStartTime) + (predictdistance * 1000));


                            latencyQueue.remove();

                        }


                        if(downloadQueue.size() >= historysize)
                        {
                            //System.out.println(downloadQueue.size());
                            pdownload = predictonQueues(downloadQueue, "download",2);
                            LogData.pnetthroughputWrite(Integer.toString(pdownload), (System.nanoTime() - ResultReciever.systemStartTime)+(predictdistance*1000));

                            pdownload = predictonQueues(downloadQueue, "download",3);
                            LogData.p3netthroughputWrite(Integer.toString(pdownload), (System.nanoTime() - ResultReciever.systemStartTime) + (predictdistance * 1000));

                            pdownload = predictonQueues(downloadQueue, "download",4);
                            LogData.p4netthroughputWrite(Integer.toString(pdownload), (System.nanoTime() - ResultReciever.systemStartTime) + (predictdistance * 1000));

                            downloadQueue.remove();

                        }

                        if(cputhroughputQueue.size() >= historysize)
                        {
                            //System.out.println(cputhroughputQueue.size());
                            pcputhroughput = predictonQueues(cputhroughputQueue, "cpu throughput",2);
                            LogData.pcputhroughputWrite(Float.toString(pcputhroughput), (System.nanoTime() - ResultReciever.systemStartTime)+(predictdistance*1000));

                            pcputhroughput = predictonQueues(cputhroughputQueue, "cpu throughput",3);
                            LogData.p3cputhroughputWrite(Float.toString(pcputhroughput), (System.nanoTime() - ResultReciever.systemStartTime) + (predictdistance * 1000));

                            pcputhroughput = predictonQueues(cputhroughputQueue, "cpu throughput",4);
                            LogData.p4cputhroughputWrite(Float.toString(pcputhroughput), (System.nanoTime() - ResultReciever.systemStartTime) + (predictdistance * 1000));

                            cputhroughputQueue.remove();

                        }

                        if(eventspersecQueue.size() >= historysize)
                        {
                            //System.out.println(eventspersecQueue.size());
                            peventspersec = predictonQueues(eventspersecQueue, "eventspersec",2);
                            LogData.peventthroughputWrite(Integer.toString(peventspersec), (System.nanoTime() - ResultReciever.systemStartTime)+(predictdistance*1000));

                            peventspersec = predictonQueues(eventspersecQueue, "eventspersec",3);
                            LogData.p3eventthroughputWrite(Integer.toString(peventspersec), (System.nanoTime() - ResultReciever.systemStartTime)+(predictdistance*1000));

                            peventspersec = predictonQueues(eventspersecQueue, "eventspersec",4);
                            LogData.p4eventthroughputWrite(Integer.toString(peventspersec), (System.nanoTime() - ResultReciever.systemStartTime)+(predictdistance*1000));

                            eventspersecQueue.remove();

                        }




                        Thread.sleep(1000);


                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }

                }
            }
        });



    }



    public static int predictonQueues(Queue queue ,String predicttype , int pol)
    {

        //Queue<Double> tempQueue = new LinkedList<Double>();
       // tempQueue = queuex;

        double[] x = new double[queue.size()];
        double[] y = new double[queue.size()];

        for (int i = 0; i < x.length; i++)
        {
            x[i] = i*1000;
            //y[i] = Double.valueOf(queue.poll().toString());

        }
        int n =0;
        for(Object object : queue) {

            y[n] = Double.valueOf(object.toString());
            n++;
        }




        PolynomialRegression regression4 = new PolynomialRegression(x, y, 4);
        PolynomialRegression regression3 = new PolynomialRegression(x, y, 3);
        PolynomialRegression regression2 = new PolynomialRegression(x, y, 2);
        PolynomialRegression regression = new PolynomialRegression(x, y, 1);

        /**
        for (int i = 0; i < y.length ; i++) {
            System.out.print(y[i]+" ");
        }
*/
        //System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+predicttype+"  predict "+regression.predict((x.length+predictdistance)));
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+predicttype+"  predict "+regression2.predict((x.length+predictdistance)));
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+predicttype+"  predict "+regression3.predict((x.length+predictdistance)));
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+predicttype+"  predict "+regression4.predict((x.length+predictdistance)));
        //System.out.println(latencyQueue.size());

        if(pol==4) {
        return (int) regression4.predict((x.length + predictdistance));
        }
        if(pol==3) {
            return (int) regression3.predict((x.length + predictdistance));
        }
        if(pol==2) {
            return (int) regression2.predict((x.length + predictdistance));
        }
        else
        {

            return  0;
        }

    }






}
