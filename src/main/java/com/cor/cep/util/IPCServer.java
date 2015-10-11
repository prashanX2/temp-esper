package com.cor.cep.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cor.cep.event.AccelerationEvent;
import com.cor.cep.event.GravityEvent;
import com.cor.cep.event.RotationEvent;
import com.cor.cep.event.OrientationEvent;
import com.cor.cep.event.HumidityEvent;
import com.cor.cep.event.DistanceEvent;


import com.cor.cep.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cor.cep.event.LuminousEvent;


/**
 * Just a simple class to create a number of Random TemperatureEvents and pass them off to the
 * TemperatureEventHandler.
 */
@Component
public class IPCServer {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(IPCServer.class);

    /** The TemperatureEventHandler - wraps the Esper engine and processes the Events  */
    @Autowired
    private  TemperatureEventHandler temperatureEventHandler;

    @Autowired
    private LuminousEventHandler luminousEventHandler;

    @Autowired
    private AccelerationEventHandler accelerationEventHandler;

    @Autowired
    private GravityEventHandler gravityEventHandler;

    @Autowired
    private RotationEventHandler rotationEventHandler;

    @Autowired
    private OrientationEventHandler orientationEventHandler;

    @Autowired
    private HumidityEventHandler humidityEventHandler;

    @Autowired
    private DistanceEventHandler distanceEventHandler;





    /**
     * IPC server, receive data and generate events
     */
    public void startSendingTemperatureReadings(final long noOfTemperatureEvents) {

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        try {
            final DatagramSocket serverSocket = new DatagramSocket(33333);

            System.out.println("Server started on main: " + serverSocket.getLocalAddress() + "@" + serverSocket.getLocalPort());

            final byte[] receiveData = new byte[1024];
            final byte[] sendData = new byte[1024];




            xrayExecutor.submit(new Runnable() {
                public void run() {

                    while (true) {


                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);


                        try {
                            serverSocket.receive(receivePacket);

                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }

                        String sentence = new String(receivePacket.getData());
                        String decode[] = sentence.split(" ");

                      

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


                        Arrays.fill(receiveData, (byte) 0);

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            LOG.error("Thread Interrupted", e);
                        }
                    }

                }
            });

        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }



            public void H001Gen()
            {
                Date timestamp = new Date();

                AccelerationEvent accel = new AccelerationEvent(IPCServer_H001.getaccelx(),IPCServer_H001.getaccely(),IPCServer_H001.getaccelz(),timestamp);
                GravityEvent gravity = new GravityEvent(IPCServer_H001.getgravityx(),IPCServer_H001.getgravityy(),IPCServer_H001.getgravityz(),timestamp);
                RotationEvent rotation = new RotationEvent(IPCServer_H001.getrotationx(),IPCServer_H001.getrotationy(),IPCServer_H001.getrotationz(),timestamp);
                OrientationEvent orientation = new OrientationEvent(IPCServer_H001.getazi(),IPCServer_H001.getpitch(),IPCServer_H001.getroll(),timestamp);
                LuminousEvent luminous = new LuminousEvent(IPCServer_H001.getlumi(), timestamp);


                accelerationEventHandler.handle(accel);
                gravityEventHandler.handle(gravity);
                rotationEventHandler.handle(rotation);
                orientationEventHandler.handle(orientation);
                luminousEventHandler.handle(luminous);

            }






            public void STH1Gen()
            {
                Date timestamp = new Date();

                HumidityEvent humidity = new HumidityEvent(IPCServer_STH1.getHumidity(),timestamp);

                humidityEventHandler.handle(humidity);

            }



            public void SD01Gen()
            {
                Date timestamp = new Date();

                DistanceEvent distance = new DistanceEvent(IPCServer_SD01.getDistance(),timestamp);

                distanceEventHandler.handle(distance);

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
