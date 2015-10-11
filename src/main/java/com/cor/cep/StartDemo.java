package com.cor.cep;

import com.cor.cep.util.IPCServer_H001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cor.cep.util.RandomTemperatureEventGenerator;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Entry point for the Demo. Run this from your IDE, or from the command line using 'mvn exec:java'.
 */
public class StartDemo {



    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(StartDemo.class);

    public static void serverStart()
    {
        try {
        final DatagramSocket serverSocket = new DatagramSocket(33333);

        System.out.println("Server started on: " + serverSocket.getLocalAddress() + "@" + serverSocket.getLocalPort());

        final byte[] receiveData = new byte[1024];
        final byte[] sendData = new byte[1024];

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();

        xrayExecutor.submit(new Runnable() {
            public void run() {

                while (true) {

                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                    try {
                        serverSocket.receive(receivePacket);
                    }catch(Exception ex)
                    {
                        System.out.println(ex.toString());
                    }

                    String sentence = new String(receivePacket.getData());
                    String decode[] = sentence.split(" ");

                    //System.out.println(sentence);

                    //sentence=null;

                    if (decode[0].equals("H001")) {
                        IPCServer_H001.decodeStream(decode);


                    }

                    if(decode[0].equals("STH1"))
                    {


                    }

                    if(decode[0].equals("SD01"))
                    {


                    }


                    Arrays.fill(receiveData,(byte)0);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        LOG.error("Thread Interrupted", e);
                    }
                }

            }
        });

        }catch(Exception e)
        {
            System.out.println(e.toString());

        }










    }

    /**
     * Main method - start the Demo!
     */
    public static void main(String[] args) throws Exception {










        LOG.debug("Starting...");
        serverStart();

        long noOfTemperatureEvents = 10;

        if (args.length != 1) {
            LOG.debug("No override of number of events detected - defaulting to " + noOfTemperatureEvents + " events.");
        } else {
            noOfTemperatureEvents = Long.valueOf(args[0]);
        }

        // Load spring config
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });
        BeanFactory factory = (BeanFactory) appContext;

        // Start Demo
        RandomTemperatureEventGenerator generator = (RandomTemperatureEventGenerator) factory.getBean("eventGenerator");
        generator.startSendingTemperatureReadings(noOfTemperatureEvents);

    }

}
