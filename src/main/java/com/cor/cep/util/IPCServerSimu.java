package com.cor.cep.util;


import com.cor.cep.event.*;
import com.cor.cep.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IPCServerSimu {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(IPCServer.class);

    /** The TemperatureEventHandler - wraps the Esper engine and processes the Events  */

    //public  static TemperatureEventHandler temperatureEventHandler = new TemperatureEventHandler();


    //public static LuminousEventHandler luminousEventHandler = new LuminousEventHandler();


    //public static AccelerationEventHandler accelerationEventHandler = new AccelerationEventHandler();


    //public static GravityEventHandler gravityEventHandler = new GravityEventHandler();


    //public static RotationEventHandler rotationEventHandler = new RotationEventHandler();


    //public static OrientationEventHandler orientationEventHandler = new OrientationEventHandler();


    //public static HumidityEventHandler humidityEventHandler = new HumidityEventHandler();


    //public static DistanceEventHandler distanceEventHandler = new DistanceEventHandler();

    //public static FinalEventHandler resultEvents = new FinalEventHandler();





    /**
     * IPC server, receive data and generate events
     */
    public void startSendingTemperatureReadings(final long noOfTemperatureEvents) {

        ExecutorService xxrayExecutor = Executors.newSingleThreadExecutor();


        try {
            //final DatagramSocket serverSocket = new DatagramSocket(33333);

            //System.out.println("Server started on main: " + serverSocket.getLocalAddress() + "@" + serverSocket.getLocalPort());

           // final byte[] receiveData = new byte[1024];
            //final byte[] sendData = new byte[1024];



            ResultReciever.systemStartTime = System.nanoTime();

            xxrayExecutor.submit(new Runnable() {
                public void run() {

                    System.out.println("-----------------------------------SIMULATOR STARTED");
                    String temp = "";

                    long atime = 0;

                    int timeinterval = 0;
                    int temptimeinterval = 0;

                    try  {

                        FileInputStream fstream = new FileInputStream("datalog1.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));



                        String line1;
                        String line2;


                        while (true) {

                            if((line1 = br.readLine()) != null)
                            {
                                //System.out.println(line1);


                            }

                            else
                            {

                                System.out.println("-----------------------------SIMULATOR ENDED: TIME ELAPSED "+(System.nanoTime()-ResultReciever.systemStartTime)/1000000);

                                System.exit(0);
                                break;
                            }

                            //DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);


                            /*try {
                                serverSocket.receive(receivePacket);
                                //System.out.println("packet recieved");
                                atime = System.nanoTime() - ResultReciever.systemStartTime;

                            } catch (Exception ex) {
                                System.out.println(ex.toString());
                            }
                                */





                            String sentence1 = line1;
                            //sentence = sentence.replace("\00", "");



                                //temp = sentence;
                                //LogData.writetoFile(sentence, atime);
                                String decode[] = sentence1.split(" ");

                                double t1 = Double.parseDouble(decode[decode.length-1])*1000;



                                timeinterval =  ((int)t1 - temptimeinterval);

                                temptimeinterval =  (int)t1;
                                //System.out.println(sentence);


                                if (decode[0].equals("H001")) {
                                    IPCServer_H001.decodeStream(decode);
                                    H001Gen();

                                }

                                if (decode[0].equals("STH1")) {
                                    IPCServer_STH1.decodeStream(decode);
                                    STH1Gen();


                                }

                                if (decode[0].equals("SD01")) {
                                    IPCServer_SD01.decodeStream(decode);
                                    SD01Gen();
                                }


                                //Arrays.fill(receiveData, (byte) 0);

                                try {
                                   // System.out.println("-----------------------------------SIMULATOR THREAD SLEEP TIME: "+timeinterval);

                                    Thread.sleep(timeinterval);
                                } catch (InterruptedException e) {
                                    LOG.error("Thread Interrupted", e);
                                }

                        }
                    }catch(Exception rt){  System.out.println(rt.toString());}
                }
            });

        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }



    public void H001Gen()
    {
        Date timestamp = new Date();

        AccelerationEvent accel = new AccelerationEvent(IPCServer_H001.getaccelx(),IPCServer_H001.getaccely(),IPCServer_H001.getaccelz(),timestamp,EventPriorities.getAccelP(),System.nanoTime());
        GravityEvent gravity = new GravityEvent(IPCServer_H001.getgravityx(),IPCServer_H001.getgravityy(),IPCServer_H001.getgravityz(),timestamp,EventPriorities.getGravityP(),System.nanoTime());
        RotationEvent rotation = new RotationEvent(IPCServer_H001.getrotationx(),IPCServer_H001.getrotationy(),IPCServer_H001.getrotationz(),timestamp,EventPriorities.getRotationP(),System.nanoTime());
        OrientationEvent orientation = new OrientationEvent(IPCServer_H001.getazi(),IPCServer_H001.getpitch(),IPCServer_H001.getroll(),timestamp,EventPriorities.getOrientationP(),System.nanoTime());
        LuminousEvent luminous = new LuminousEvent(IPCServer_H001.getlumi(), timestamp,EventPriorities.getLuminousP(),System.nanoTime());


        IPCServer.accelerationEventHandler.handle(accel);
        IPCServer.gravityEventHandler.handle(gravity);
        IPCServer.rotationEventHandler.handle(rotation);
        IPCServer.orientationEventHandler.handle(orientation);
        IPCServer.luminousEventHandler.handle(luminous);

    }






    public void STH1Gen()
    {
        Date timestamp = new Date();

        HumidityEvent humidity = new HumidityEvent(IPCServer_STH1.getHumidity(),timestamp,EventPriorities.getHumidityP(),System.nanoTime());
        TemperatureEvent temperature = new TemperatureEvent(IPCServer_STH1.getTemp(),timestamp, EventPriorities.getTemperatureP(),System.nanoTime());

        IPCServer.humidityEventHandler.handle(humidity);
        IPCServer.temperatureEventHandler.handle(temperature);

    }



    public void SD01Gen()
    {
        Date timestamp = new Date();

        DistanceEvent distance = new DistanceEvent(IPCServer_SD01.getDistance(),timestamp,EventPriorities.getDistanceP(),System.nanoTime());

        IPCServer.distanceEventHandler.handle(distance);

    }






    private String getStartingMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n************************************************************");
        sb.append("\n* STARTING - ");
        sb.append("\n* PLEASE WAIT - TEMPERATURES ARE RANDOM SO MAY TAKE");
        sb.append("\n* A WHILE TO SEE WARNING AND CRITICAL EVENTS!");
        sb.append("\n************************************************************\n");
        return sb.toString();
    }
}
