package com.cor.cep;

import com.cor.cep.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Entry point for the Demo. Run this from your IDE, or from the command line using 'mvn exec:java'.
 */
public class StartDemo {

    public static volatile boolean lock;

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(StartDemo.class);







    /**
     * Main method - start the Demo!
     */
    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);

        System.out.println("Is this cloud?: ");
        String answer = sc.nextLine();

        if(answer.equals("n"))
        {
            FogToCloudGateway.initgatewayclient();


        }
        else if(answer.equals("y"))
        {
            FogToCloudGateway.isCloud=true;

            FogToCloudGateway.initgatewayserver();

        }

        System.out.println("Number of CPU cores: ");

        String answercores = sc.nextLine();

        CpuThroughput.cpuCores = Integer.parseInt(answercores);

        LOG.debug("Starting...");


        long noOfTemperatureEvents = 100000;



        if (args.length != 1) {
            LOG.debug("No override of number of events detected - defaulting to " + noOfTemperatureEvents + " events.");
        } else {
            noOfTemperatureEvents = Long.valueOf(args[0]);
        }

        // Load spring config

        //ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });
       // BeanFactory factory = (BeanFactory) appContext;

        // Start Demo

        //serverStart();



        NetworkLatency latency = new NetworkLatency();
        latency.clientLatency();

        NetworkThroughput throughput = new NetworkThroughput();
        throughput.runThroughput();

        CpuThroughput cputhroughput = new CpuThroughput();
        cputhroughput.runCpuThroughput();



        FogToCloudGateway.initgatewayclient();

        //IPCServer generator = (IPCServer) factory.getBean("eventGenerator");
        IPCServer generator = new IPCServer();
       generator.startSendingTemperatureReadings(noOfTemperatureEvents);

        EventsThroughput eventmonitor = new EventsThroughput();
        eventmonitor.runEventThroughput();








        //IPCServer server = new IPCServer();
        //server.serverStart();


    }

}
