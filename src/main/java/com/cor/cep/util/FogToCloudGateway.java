package com.cor.cep.util;


import com.cor.cep.event.*;
import com.cor.cep.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class FogToCloudGateway {


    /**handlers for cloudside engine*/


    public static TemperatureEventHandler gtemperatureEventHandler = IPCServer.temperatureEventHandler;


    public static LuminousEventHandler gluminousEventHandler = IPCServer.luminousEventHandler;


    public static AccelerationEventHandler gaccelerationEventHandler = IPCServer.accelerationEventHandler;


    public static GravityEventHandler ggravityEventHandler = IPCServer.gravityEventHandler;


    public static RotationEventHandler grotationEventHandler = IPCServer.rotationEventHandler;


    public static OrientationEventHandler gorientationEventHandler = IPCServer.orientationEventHandler;


    public static HumidityEventHandler ghumidityEventHandler = IPCServer.humidityEventHandler;


    public static DistanceEventHandler gdistanceEventHandler = IPCServer.distanceEventHandler;

    public static FinalEventHandler gresultEvents = IPCServer.resultEvents;







    public static String clientAddress;

    public static boolean isCloud = false;
    public static Socket gatewayclientSocket;
    public static InetAddress gatewayserverIPAddress;
    public static DataOutputStream outToServer;


    //public static DatagramSocket gatewayserverSocket;
    public static  ServerSocket gatewayserverSocket;

    public static int eventPacektSize = 1; // in KB
    public static int maxBandwidth = 1024; // in KB



    private static Logger gLOG = LoggerFactory.getLogger(FogToCloudGateway.class);


    public static void initgatewayclient()
    {
        try
        {
//104.43.197.157
            //gatewayserverIPAddress = InetAddress.getByName("localhost");
            //gatewayclientSocket = new Socket(gatewayserverIPAddress, 55555);


        }catch(Exception e){System.out.println("client gateway socket  "+e.toString());}


    }


    public static void initgatewayserver()
    {
        try
        {
            gatewayserverSocket = new ServerSocket(55555);


            System.out.println("gateway server started....");
            //final byte[] gatewayreceiveData = new byte[1024];



            ExecutorService serverExecutor = Executors.newSingleThreadExecutor();

            serverExecutor.submit(new Runnable() {
                public void run() {

                    while (true) {




                        //DatagramPacket receivePacket = new DatagramPacket(gatewayreceiveData, gatewayreceiveData.length);


                        try {

                            Socket connectionSocket = gatewayserverSocket.accept();
                            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                            connectionSocket.getRemoteSocketAddress().toString();
                            //DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                            String clientSentence = inFromClient.readLine();
                            System.out.println("-----------------------packet Received from "+clientAddress+" :" + clientSentence);

                            String decode[] = clientSentence.split(" ");



                          /**sensor hub 1 events (H001)*/

                            if(decode[0].equals("ACCE"))
                            {


                                Date timestamp = new Date();


                                AccelerationEvent accel = new AccelerationEvent(Float.parseFloat(decode[2]),Float.parseFloat(decode[3]),Float.parseFloat(decode[4]),timestamp,EventPriorities.getAccelP(),Long.parseLong(decode[5]));
                                gaccelerationEventHandler.handle(accel);

                            }


                            if(decode[0].equals("GRAV"))
                            {


                                Date timestamp = new Date();


                                GravityEvent gravity = new GravityEvent(Float.parseFloat(decode[2]),Float.parseFloat(decode[3]),Float.parseFloat(decode[4]),timestamp,EventPriorities.getGravityP(),Long.parseLong(decode[5]));

                                ggravityEventHandler.handle(gravity);

                            }

                            if(decode[0].equals("ROTA"))
                            {


                                Date timestamp = new Date();


                                RotationEvent rotation = new RotationEvent(Float.parseFloat(decode[2]),Float.parseFloat(decode[3]),Float.parseFloat(decode[4]),timestamp,EventPriorities.getRotationP(),Long.parseLong(decode[5]));

                                grotationEventHandler.handle(rotation);

                            }

                            if(decode[0].equals("ORIE"))
                            {


                                Date timestamp = new Date();


                                OrientationEvent orientation = new OrientationEvent(Integer.parseInt(decode[2]),Integer.parseInt(decode[3]),Integer.parseInt(decode[4]),timestamp,EventPriorities.getOrientationP(),Long.parseLong(decode[5]));

                                gorientationEventHandler.handle(orientation);

                            }

                            if(decode[0].equals("LUMI"))
                            {


                                Date timestamp = new Date();


                                LuminousEvent luminous = new LuminousEvent(Integer.parseInt(decode[2]), timestamp,EventPriorities.getLuminousP(),Long.parseLong(decode[3]));
                                gluminousEventHandler.handle(luminous);

                            }



                            /**stand alone sensors 1 (STH1)*/

                            if(decode[0].equals("HUMI"))
                            {


                                Date timestamp = new Date();


                                HumidityEvent humidity = new HumidityEvent(Integer.parseInt(decode[2]),timestamp,EventPriorities.getHumidityP(),Long.parseLong(decode[3]));
                                ghumidityEventHandler.handle(humidity);

                            }

                            if(decode[0].equals("TEMP"))
                            {


                                Date timestamp = new Date();


                                TemperatureEvent temperature = new TemperatureEvent(Integer.parseInt(decode[2]),timestamp, EventPriorities.getTemperatureP(),Long.parseLong(decode[3]));
                                gtemperatureEventHandler.handle(temperature);

                            }


                            /**stand alone sensors 2 (SD01)*/

                            if(decode[0].equals("DIST"))
                            {


                                Date timestamp = new Date();


                                DistanceEvent distance = new DistanceEvent(Integer.parseInt(decode[2]),timestamp,EventPriorities.getDistanceP(),Long.parseLong(decode[3]));
                                gdistanceEventHandler.handle(distance);

                            }


                            /**secondary events*/

                            if(decode[0].equals("ENTE"))
                            {


                                Date timestamp = new Date();


                                EnteredEvent event = new EnteredEvent(Integer.parseInt(decode[2]),Integer.parseInt(decode[3]),timestamp, EventPriorities.getentered(),Long.parseLong(decode[4]));
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


                                AvgHumiEvent avgHumiEvent = new AvgHumiEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getavghumi(),Long.parseLong(decode[3]));
                                gLOG.debug(avgHumiEvent.toString());
                                epService.epService.getEPRuntime().sendEvent(avgHumiEvent);
                                EventsThroughput.AVGhumicount+=1;

                            }

                            if(decode[0].equals("WHUM"))
                            {


                                Date timestamp = new Date();


                                WarnHumiEvent warnHumiEvent = new WarnHumiEvent(Integer.parseInt(decode[2]), timestamp,EventPriorities.getwarnhumi(),Long.parseLong(decode[3]));
                                gLOG.debug(warnHumiEvent.toString());

                                epService.epService.getEPRuntime().sendEvent(warnHumiEvent);
                                EventsThroughput.warnhumicount+=1;

                            }

                            // luminous secondary events
                            if(decode[0].equals("ALUM"))
                            {


                                Date timestamp = new Date();


                                AvgLumiEvent avgLumiEvent = new AvgLumiEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getavglumi(),Long.parseLong(decode[3]));
                                gLOG.debug(avgLumiEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(avgLumiEvent);
                                EventsThroughput.AVGlumicount+=1;

                            }

                            if(decode[0].equals("WLUM"))
                            {


                                Date timestamp = new Date();


                                WarnLumiEvent warnLumiEvent = new WarnLumiEvent(Integer.parseInt(decode[2]), timestamp ,EventPriorities.getwarnlumi(),Long.parseLong(decode[3]));
                                gLOG.debug(warnLumiEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(warnLumiEvent);
                                EventsThroughput.warnlumicount+=1;

                            }

                            // temperature secondary events
                            if(decode[0].equals("ATEM"))
                            {


                                Date timestamp = new Date();


                                AvgTempEvent avgTempEvent = new AvgTempEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getavgtemp(),Long.parseLong(decode[3]));
                                gLOG.debug(avgTempEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(avgTempEvent);
                                EventsThroughput.AVGtempcount+=1;

                            }

                            if(decode[0].equals("WTEM"))
                            {


                                Date timestamp = new Date();


                                WarnTempEvent warnTempEvent = new WarnTempEvent(Integer.parseInt(decode[2]), timestamp, EventPriorities.getwarntemp(),Long.parseLong(decode[3]));
                                gLOG.debug(warnTempEvent.toString());


                                epService.epService.getEPRuntime().sendEvent(warnTempEvent);
                                EventsThroughput.warntempcount+=1;

                            }










                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }


                       // Arrays.fill(gatewayreceiveData, (byte) 0);

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




    public static boolean schedule(int priority, String eventID)
    {

        if(isCloud)
        {
            return false;
        }
        else
        {
            /**
            return scheduletoCloud(priority,eventID);
             */
            return true;
        }

    }


    public static boolean scheduletoCloud(int priority, String eventID)
    {

        priority = EventTree.getTreeValue(priority, eventID);
        if(eventID.equals("ALUM")) {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + eventID + " " + priority);
        }
        /**high priority and primary events*/
        if(priority>4)
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
            else if(CpuThroughput.cpuLoad > 7 && NetworkLatency.latency < 3000)
            {
                System.out.println("IN THE OEIROITY <3");
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



    /**Predict system behaviour for X number of seconds before hand and schedule accordingly*/
    public static boolean pscheduletoCloud(int priority, String eventID)
    {

        priority = EventTree.getTreeValue(priority, eventID);
        if(eventID.equals("ALUM")) {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + eventID + " " + priority);
        }
        /**high priority and primary events*/
        if(priority>4)
        {
            /**if max number of events that the engine can handle is reached send to cloud*/
            if(Predict.peventspersec > EventsThroughput.maxEventsPerSec)
            {

                return true;
            }

            /**if cpu load is extreme and latency is acceptable send to cloud*/
            else if(Predict.pcputhroughput >100 && Predict.platency <500)
            {
                return true;
            }

            /**if cpu load is extreme and latency is very high dont send to cloud*/
            else if(Predict.pcputhroughput >100 && Predict.platency >1000)
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
            if(Predict.peventspersec > EventsThroughput.maxEventsPerSec)
            {

                return true;
            }

            /**if cpu load is medium and latency is acceptable send to cloud*/
            else if(Predict.pcputhroughput > 50 && Predict.platency < 1000)
            {
                return true;
            }

            /**if the band width utilization is high and cpu load is medium dont send to cloud*/
            else if(Predict.pcputhroughput < 50 && (maxBandwidth - Predict.pdownload) < 50)
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
            if(Predict.peventspersec > EventsThroughput.maxEventsPerSec)
            {

                return true;
            }

            /**if cpu load is medium and latency is acceptable send to cloud*/
            else if(Predict.pcputhroughput > 7 && Predict.platency < 3000)
            {
                System.out.println("IN THE OEIROITY <3");
                return true;

            }

            /**if the band width utilization is high and cpu load is medium dont send to cloud*/
            else if(Predict.pcputhroughput < 30 && (maxBandwidth - Predict.pdownload) < 200)
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
        //byte[] sendData = new byte[1024];

        //sendData = toSend.getBytes();

        //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, gatewayserverIPAddress, 55555);

        try
        {
            //outToServer = new DataOutputStream(gatewayclientSocket.getOutputStream());
            //outToServer.writeBytes(toSend);

            Socket clientSocket = new Socket("104.43.197.157", 55555);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //String sentence = toSend;
            outToServer.writeBytes(toSend);

            //modifiedSentence = inFromServer.readLine();
            System.out.println("Sent top server "+toSend);
            clientSocket.close();
        }catch(Exception e){System.out.println(e.toString());}



    }
    //104.43.197.157














}
