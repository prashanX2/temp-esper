package com.cor.cep.handler;

import com.cor.cep.event.LuminousEvent;
import com.cor.cep.subscriber.luminous.LumiCriticalEventSubscriber;
import com.cor.cep.subscriber.luminous.LumiMonitorEventSubscriber;
import com.cor.cep.subscriber.luminous.LumiWarningEventSubscriber;
import com.cor.cep.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cor.cep.subscriber.StatementSubscriber;
import com.espertech.esper.client.EPStatement;

/**
 * This class handles incoming Luminous Events. It processes them through the EPService, to which
 * it has attached the 3 queries.
 */

public class LuminousEventHandler {


    public LuminousEventHandler(){afterPropertiesSet();}
    /**
     * Logger
     */
    private static Logger LOG = LoggerFactory.getLogger(LuminousEventHandler.class);

    /**
     * Esper service
     */
    //private EPServiceProvider epService;
    private EPStatement lumicriticalEventStatement;
    private EPStatement lumiwarningEventStatement;
    private EPStatement lumimonitorEventStatement;





    private  static String[] attributes = new String[10];



    private LumiCriticalEventSubscriber lumiCriticalEventSubscriber = new LumiCriticalEventSubscriber();


    private LumiWarningEventSubscriber lumiWarningEventSubscriber = new LumiWarningEventSubscriber();


    private LumiMonitorEventSubscriber lumiMonitorEventSubscriber = new LumiMonitorEventSubscriber();


    /**
     * Configure Esper Statement(s).
     */
    public void initService() {

        LOG.debug("Initializing Servcie [lumi] ..");
        epService.initService();

       /* Configuration config = new Configuration();
        config.addEventTypeAutoName("com.cor.cep.event");
        epService.epService = EPServiceProviderManager.getDefaultProvider(config);
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

        LOG.debug("create Critical Luminous Check Expression");
        lumicriticalEventStatement = epService.epService.getEPAdministrator().createEPL(lumiCriticalEventSubscriber.getStatement());
        lumicriticalEventStatement.setSubscriber(lumiCriticalEventSubscriber);
    }

    /**
     * EPL to check for 2 consecutive Temperature events over the threshold - if matched, will alert
     * listener.
     */
    private void createWarningTemperatureCheckExpression() {

        LOG.debug("create Warning Luminous Check Expression");
        lumiwarningEventStatement = epService.epService.getEPAdministrator().createEPL(lumiWarningEventSubscriber.getStatement());
        lumiwarningEventStatement.setSubscriber(lumiWarningEventSubscriber);
    }

    /**
     * EPL to monitor the average temperature every 10 seconds. Will call listener on every event.
     */
    private void createTemperatureMonitorExpression() {

        LOG.debug("create Timed Average Luminous Monitor");
        lumimonitorEventStatement = epService.epService.getEPAdministrator().createEPL(lumiMonitorEventSubscriber.getStatement());
        lumimonitorEventStatement.setSubscriber(lumiMonitorEventSubscriber);
    }

    /**
     * Handle the incoming TemperatureEvent.
     */
    public void handle(LuminousEvent event) {


        //attributes[0] = event.getID();
        //attributes[1] = Integer.toString(event.getPriority());
        //attributes[2] = Integer.toString(event.getluminous());
        //attributes[3] = event.getTimeOfReading();

        //LOG.debug(event.toString());


        if(FogToCloudGateway.schedule(event.getPriority(),event.getID()))
        {
            String eventtoSend = event.getID()+" "+event.getPriority()+" "+event.getluminous()+" "+event.getTime()+" "+event.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

           // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {
            LOG.debug(event.toString());
            epService.epService.getEPRuntime().sendEvent(event);
            //EventPriorities.eventCountadd();
            if(!FogToCloudGateway.isCloud){
                LogData.LUMIWrite(Float.toString(event.getluminous()), System.nanoTime() - ResultReciever.systemStartTime);
            }else
            {
                String eventtoSend = event.getID()+" "+event.getPriority()+" "+event.getluminous()+" "+event.getTime()+" "+event.getTimeOfReading();

                ResultSender.send(eventtoSend);
            }

            EventsThroughput.lumicount+=1;

        }



        //epService.epService.getEPRuntime().sendEvent(event);
        //EventPriorities.eventCountadd();
       // EventsThroughput.lumicount+=1;

    }


    public void afterPropertiesSet() {

        LOG.debug("Configuring..");
        initService();
    }

}