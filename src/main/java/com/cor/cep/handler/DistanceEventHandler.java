package com.cor.cep.handler;

import com.cor.cep.event.DistanceEvent;
import com.cor.cep.event.HumidityEvent;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import com.cor.cep.util.FogToCloudGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;




import com.espertech.esper.client.EPStatement;

import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.subscriber.distance.DistanceWarningEventSubscriber;



public class DistanceEventHandler {

    public DistanceEventHandler()
    {
        afterPropertiesSet();

    }


    /**
     * Logger
     */
    private static Logger tempLOG = LoggerFactory.getLogger(TemperatureEventHandler.class);

    /**
     * Esper service
     */
    //private EPServiceProvider epService;
    //private EPStatement tempcriticalEventStatement;
    private EPStatement distancewarningEventStatement;
    //private EPStatement tempmonitorEventStatement;

   /* @Autowired
    @Qualifier("tempCriticalEventSubscriber")
    private StatementSubscriber tempCriticalEventSubscriber;

*/

   DistanceWarningEventSubscriber distanceWarningEventSubscriber = new DistanceWarningEventSubscriber();
/*
    @Autowired
    @Qualifier("tempMonitorEventSubscriber")
    private StatementSubscriber tempMonitorEventSubscriber;
    */


    /**
     * Configure Esper Statement(s).
     */
    public void initService() {

        tempLOG.debug("Initializing Servcie [distance] ..");
        epService.initService();
        /*Configuration config = new Configuration();
        config.addEventTypeAutoName("com.cor.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);
         */
        // createCriticalTemperatureCheckExpression();
        createWarningDistanceCheckExpression();
        //createTemperatureMonitorExpression();

    }


    /**
     * EPL to check for a sudden critical rise across 4 events, where the last event is 1.5x greater
     * than the first event. This is checking for a sudden, sustained escalating rise in the
     * temperature
     */

    /*
    private void createCriticalTemperatureCheckExpression() {

        tempLOG.debug("create Critical Temperature Check Expression");
        tempcriticalEventStatement = epService.epService.getEPAdministrator().createEPL(tempCriticalEventSubscriber.getStatement());
        tempcriticalEventStatement.setSubscriber(tempCriticalEventSubscriber);
    }


     * EPL to check for 2 consecutive Distance events over the threshold - if matched, will alert
     * listener.
     */


    private void createWarningDistanceCheckExpression() {

        tempLOG.debug("create Warning Distance Check Expression");
        distancewarningEventStatement = epService.epService.getEPAdministrator().createEPL(distanceWarningEventSubscriber.getStatement());
        distancewarningEventStatement.setSubscriber(distanceWarningEventSubscriber);
    }

    /**
     * EPL to monitor the average temperature every 10 seconds. Will call listener on every event.
     */

    /*
    private void createTemperatureMonitorExpression() {

        tempLOG.debug("create Timed Average Monitor");
        tempmonitorEventStatement = epService.epService.getEPAdministrator().createEPL(tempMonitorEventSubscriber.getStatement());
        tempmonitorEventStatement.setSubscriber(tempMonitorEventSubscriber);
    }

    /**
     * Handle the incoming TemperatureEvent.
     */



    public void handle(DistanceEvent event) {



        if(FogToCloudGateway.schedule(event.getPriority()))
        {
            String eventtoSend = event.getID()+" "+event.getPriority()+" "+event.getDistance()+" "+event.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {
            tempLOG.debug(event.toString());
            epService.epService.getEPRuntime().sendEvent(event);
            //EventPriorities.eventCountadd();
            EventsThroughput.distancecount+=1;

        }




        //tempLOG.debug(event.toString());
       // epService.epService.getEPRuntime().sendEvent(event);
        //EventPriorities.eventCountadd();
        //EventsThroughput.distancecount += 1;

    }


    public void afterPropertiesSet() {

        tempLOG.debug("Configuring..");
        initService();
    }
}
