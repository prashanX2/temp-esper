package com.cor.cep.util;


import com.cor.cep.event.*;
import com.cor.cep.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class FogToCloudGateway {


    /**handlers for cloudside engine*/


    public static TemperatureEventHandler gtemperatureEventHandler = new TemperatureEventHandler();


    public static LuminousEventHandler gluminousEventHandler = new LuminousEventHandler();


    public static AccelerationEventHandler gaccelerationEventHandler = new AccelerationEventHandler();


    public static GravityEventHandler ggravityEventHandler = new GravityEventHandler();


    public static RotationEventHandler grotationEventHandler = new RotationEventHandler();


    public static OrientationEventHandler gorientationEventHandler = new OrientationEventHandler();


    public static HumidityEventHandler ghumidityEventHandler = new HumidityEventHandler();


    public static DistanceEventHandler gdistanceEventHandler = new DistanceEventHandler();

    public static FinalEventHandler gresultEvents = new FinalEventHandler();








    public static boolean isCloud = false;
    public static DatagramSocket gatewayclientSocket;
    public static InetAddress gatewayserverIPAddress;


    public static DatagramSocket gatewayserverSocket;


    public static int eventPacektSize = 1; // in KB
    public static int maxBandwidth = 1024; // in KB



    private static Logger gLOG = LoggerFactory.getLogger(FogToCloudGateway.class);


    public static void initgatewayclient()
    {
        try
        {
            gatewayclientSocket= new DatagramSocket();
            gatewayserverIPAddress = InetAddress.getByName("104.43.197.157");

        }catch(Exception e){System.out.println(e.toString());}


    }


    public static void initgatewayserver()
    {
        try
        {
            gatewayserverSocket = new DatagramSocket(55555);
            System.out.println("gateway server started....");
            final byte[] gatewayreceiveData = new byte[1024];



            ExecutorService serverExecutor = Executors.newSingleThreadExecutor();

            serverExecutor.submit(new Runnable() {
                public void run() {

                    while (true) {


                        DatagramPacket receivePacket = new DatagramPacket(gatewayreceiveData, gatewayreceiveData.length);


                        try {
                            gatewayserverSocket.receive(receivePacket);
                            String sentence = new String(receivePacket.getData());
                            System.out.println("packet recieved "+sentence);

                            String decode[] = sentence.split(" ");



                          /**sensor hub 1 events (H001)*/

                            if(decode[0].equals("ACCE"))
                            {


                                Date timestamp = new Date();


                                AccelerationEvent accel = new AccelerationEvent(Float.parseFloat(decode[2]),Float.parseFloat(decode[3]),Float.parseFloat(decode[4]),timestamp,EventPriorities.getAccelP());
                                gaccelerationEventHandler.handle(accel);

                            }


                            if(decode[0].equals("GRAV"))
                            {


                                Date timestamp = new Date();


                                GravityEvent gravity = new GravityEvent(Float.parseFloat(decode[2]),Float.parseFloat(decode[3]),Float.parseFloat(decode[4]),timestamp,EventPriorities.getGravityP());

                                ggravityEventHandler.handle(gravity);

                            }

                            if(decode[0].equals("ROTA"))
                            {


                                Date timestamp = new Date();


                                RotationEvent rotation = new RotationEvent(Float.parseFloat(decode[2]),Float.parseFloat(decode[3]),Float.parseFloat(decode[4]),timestamp,EventPriorities.getRotationP());

                                grotationEventHandler.handle(rotation);

                            }

                            if(decode[0].equals("ORIE"))
                            {


                                Date timestamp = new Date();


                                OrientationEvent orientation = new OrientationEvent(Integer.parseInt(decode[2]),Integer.parseInt(decode[3]),Integer.parseInt(decode[4]),timestamp,EventPriorities.getOrientationP());

                                gorientationEventHandler.handle(orientation);

                            }

                            if(decode[0].equals("LUMI"))
                            {


                                Date timestamp = new Date();


                                LuminousEvent luminous = new LuminousEvent(Integer.parseInt(decode[2]), timestamp,EventPriorities.getLuminousP());
                                gluminousEventHandler.handle(luminous);

                            }



                            /**stand alone sensors 1 (STH1)*/

                            if(decode[0].equals("HUMI"))
                            {


                                Date timestamp = new Date();


                                HumidityEvent humidity = new HumidityEvent(Integer.parseInt(decode[2]),timestamp,EventPriorities.getHumidityP());
                                ghumidityEventHandler.handle(humidity);

                            }

                            if(decode[0].equals("TEMP"))
                            {


                                Date timestamp = new Date();


                                TemperatureEvent temperature = new TemperatureEvent(Integer.parseInt(decode[2]),timestamp, EventPriorities.getTemperatureP());
                                gtemperatureEventHandler.handle(temperature);

                            }


                            /**stand alone sensors 2 (SD01)*/

                            if(decode[0].equals("TEMP"))
                            {


                                Date timestamp = new Date();


                                DistanceEvent distance = new DistanceEvent(Integer.parseInt(decode[2]),timestamp,EventPriorities.getDistanceP());
                                gdistanceEventHandler.handle(distance);

                            }


                            /**secondary events*/

                            if(decode[0].equals("ENTE"))
                            {


                                Date timestamp = new Date();


                                EnteredEvent event = new EnteredEvent(Integer.parseInt(decode[2]),Integer.parseInt(decode[3]),timestamp, EventPriorities.getentered());
                                epService.epService.getEPRuntime().sendEvent(event);
                                //System.out.println(event.toString());
                                //EventPriorities.eventCountadd();
                                EventsThroughput.entered += 1;

                                gLOG.debug(event.toString());

                            }

                            // humidity secondary events
                            if(decode[0].equals("AHUM"))
                            {


                                Date timestamp = new Date();


                                AvgHumiEvent avgHumiEvent = new AvgHumiEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getavghumi());
                                gLOG.debug(avgHumiEvent.toString());
                                epService.epService.getEPRuntime().sendEvent(avgHumiEvent);
                                EventsThroughput.AVGhumicount+=1;

                            }

                            if(decode[0].equals("WHUM"))
                            {


                                Date timestamp = new Date();


                                WarnHumiEvent warnHumiEvent = new WarnHumiEvent(Integer.parseInt(decode[2]), timestamp,EventPriorities.getwarnhumi());
                                gLOG.debug(warnHumiEvent.toString());

                                epService.epService.getEPRuntime().sendEvent(warnHumiEvent);
                                EventsThroughput.warnhumicount+=1;

                            }

                            // luminous secondary events
                            if(decode[0].equals("ALUM"))
                            {


                                Date timestamp = new Date();


                                AvgLumiEvent avgLumiEvent = new AvgLumiEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getavglumi());
                                gLOG.debug(avgLumiEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(avgLumiEvent);
                                EventsThroughput.AVGlumicount+=1;

                            }

                            if(decode[0].equals("WLUM"))
                            {


                                Date timestamp = new Date();


                                WarnLumiEvent warnLumiEvent = new WarnLumiEvent(Integer.parseInt(decode[2]), timestamp ,EventPriorities.getwarnlumi());
                                gLOG.debug(warnLumiEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(warnLumiEvent);
                                EventsThroughput.warnlumicount+=1;

                            }

                            // temperature secondary events
                            if(decode[0].equals("ATEM"))
                            {


                                Date timestamp = new Date();


                                AvgTempEvent avgTempEvent = new AvgTempEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getavgtemp());
                                gLOG.debug(avgTempEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(avgTempEvent);
                                EventsThroughput.AVGtempcount+=1;

                            }

                            if(decode[0].equals("WTEM"))
                            {


                                Date timestamp = new Date();


                                WarnTempEvent warnTempEvent = new WarnTempEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getwarntemp());
                                gLOG.debug(warnTempEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(warnTempEvent);
                                EventsThroughput.warntempcount+=1;

                            }










                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }


                        Arrays.fill(gatewayreceiveData, (byte) 0);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            //LOG.error("Thread Interrupted", e);
                        }
                    }

                }
            });
















            //gatewayserverIPAddress = InetAddress.getByName("104.43.197.157");

        }catch(Exception e){System.out.println(e.toString());}


    }




    public static boolean schedule(int priority)
    {
        if(isCloud)
        {
            return false; // schedule locally
        }
        else
        {
            if(scheduletoCloud(priority))
            {
                return true;  // schedule in cloud
            }

            else
            {
                return false; // schedule locally
            }





        }


    }


    public static boolean scheduletoCloud(int priority)
    {

        /**high priority and primary events*/
        if(priority>5)
        {
            /**if max number of events that the engine can handle is reached send to cloud*/
            if(EventsThroughput.eventpersec > EventsThroughput.maxEventsPerSec)
            {

                return true;
            }

            /**if cpu load is extreme and latency is acceptable send to cloud*/
            else if(CpuThroughput.cpuLoad >100 && NetworkLatency.latency <500)
            {
                return true;
            }

            /**if cpu load is extreme and latency is very high dont send to cloud*/
            else if(CpuThroughput.cpuLoad >100 && NetworkLatency.latency >1000)
            {
                return false;
            }

            else
            {
                return false;

            }



        }

        /**normal priority events */
        else if(priority == 3)
        {

            /**if max number of events that the engine can handle is reached send to cloud*/
            if(EventsThroughput.eventpersec > EventsThroughput.maxEventsPerSec)
            {

                return true;
            }

            /**if cpu load is medium and latency is acceptable send to cloud*/
            else if(CpuThroughput.cpuLoad > 50 && NetworkLatency.latency < 1000)
            {
                return true;
            }

            /**if the band width utilization is high and cpu load is medium dont send to cloud*/
            else if(CpuThroughput.cpuLoad < 50 && (maxBandwidth - NetworkThroughput.download) < 50)
            {
                return false;
            }

            else
            {
                return false;
            }


        }

        /**low priority events */
        else if(priority < 3)
        {
            /**if max number of events that the engine can handle is reached send to cloud*/
            if(EventsThroughput.eventpersec > EventsThroughput.maxEventsPerSec)
            {

                return true;
            }

            /**if cpu load is medium and latency is acceptable send to cloud*/
            else if(CpuThroughput.cpuLoad > 30 && NetworkLatency.latency < 3000)
            {
                return true;
            }

            /**if the band width utilization is high and cpu load is medium dont send to cloud*/
            else if(CpuThroughput.cpuLoad < 30 && (maxBandwidth - NetworkThroughput.download) < 200)
            {
                return false;
            }

            else
            {
                return false;
            }

        }

        else
        {
            return false;

        }













    }



















    public static void sendtoCloud(String toSend)
    {
        byte[] sendData = new byte[1024];

        sendData = toSend.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, gatewayserverIPAddress, 55555);

        try
        {
            gatewayclientSocket.send(sendPacket);
            System.out.println("sent to cloud: " + toSend);
        }catch(Exception e){System.out.println(e.toString());}



    }
    //104.43.197.157














}
