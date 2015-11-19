package com.cor.cep.handler;

import com.cor.cep.subscriber.temperature.TempCriticalEventSubscriber;
import com.cor.cep.subscriber.temperature.TempMonitorEventSubscriber;
import com.cor.cep.subscriber.temperature.TempWarningEventSubscriber;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import com.cor.cep.util.FogToCloudGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cor.cep.event.TemperatureEvent;
import com.cor.cep.subscriber.StatementSubscriber;
import com.espertech.esper.client.EPStatement;

/**
 * This class handles incoming Temperature Events. It processes them through the EPService, to which
 * it has attached the 3 queries.
 */

public  class TemperatureEventHandler {


    public TemperatureEventHandler()
    {
        System.out.println("tempeventhanlder started");
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
    private EPStatement tempcriticalEventStatement;
    private EPStatement tempwarningEventStatement;
    private EPStatement tempmonitorEventStatement;


    private TempCriticalEventSubscriber tempCriticalEventSubscriber = new TempCriticalEventSubscriber();


    private TempWarningEventSubscriber tempWarningEventSubscriber = new TempWarningEventSubscriber();


    private TempMonitorEventSubscriber tempMonitorEventSubscriber = new TempMonitorEventSubscriber();

    /**
     * Configure Esper Statement(s).
     */
    public void initService() {

        tempLOG.debug("Initializing Servcie [temp] ..");
        epService.initService();
        /*Configuration config = new Configuration();
        config.addEventTypeAutoName("com.cor.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);
         */
        createCriticalTemperatureCheckExpression();
        createWarningTemperatureCheckExpression();
        createTemperatureMonitorExpression();

    }

    /**
     * EPL to check for a sudden critical rise across 4 events, where the last event is 1.5x greater
     * than the first event. This is checking for a sudden, sustained escalating rise in the
     * temperature
     */
    private void createCriticalTemperatureCheckExpression() {

        tempLOG.debug("create Critical Temperature Check Expression");
        tempcriticalEventStatement = epService.epService.getEPAdministrator().createEPL(tempCriticalEventSubscriber.getStatement());
        tempcriticalEventStatement.setSubscriber(tempCriticalEventSubscriber);
    }

    /**
     * EPL to check for 2 consecutive Temperature events over the threshold - if matched, will alert
     * listener.
     */
    private void createWarningTemperatureCheckExpression() {

        tempLOG.debug("create Warning Temperature Check Expression");
        tempwarningEventStatement = epService.epService.getEPAdministrator().createEPL(tempWarningEventSubscriber.getStatement());
        tempwarningEventStatement.setSubscriber(tempWarningEventSubscriber);
    }

    /**
     * EPL to monitor the average temperature every 10 seconds. Will call listener on every event.
     */
    private void createTemperatureMonitorExpression() {

        StatementSubscriber TempMonitorEventSubscriber;
        tempLOG.debug("create Timed Average Monitor");
        tempmonitorEventStatement = epService.epService.getEPAdministrator().createEPL(tempMonitorEventSubscriber.getStatement());
        tempmonitorEventStatement.setSubscriber(tempMonitorEventSubscriber);
    }

    /**
     * Handle the incoming TemperatureEvent.
     */
    public void handle(TemperatureEvent event) {


        if(FogToCloudGateway.schedule(event.getPriority()))
        {
            String eventtoSend = event.getID()+" "+event.getPriority()+" "+event.getTemperature()+" "+event.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {

            //System.out.println("after temp handle");
            tempLOG.debug(event.toString());
            epService.epService.getEPRuntime().sendEvent(event);
            //EventPriorities.eventCountadd();
            EventsThroughput.tempcount+=1;

        }


        //System.out.println("after temp handle");
        //tempLOG.debug(event.toString());
        //epService.epService.getEPRuntime().sendEvent(event);
        //EventPriorities.eventCountadd();
        //EventsThroughput.tempcount+=1;

    }


    public void afterPropertiesSet() {

        tempLOG.debug("Configuring..");
        initService();
    }

}