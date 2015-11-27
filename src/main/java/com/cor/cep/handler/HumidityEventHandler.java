package com.cor.cep.handler;


import com.cor.cep.event.HumidityEvent;
import com.cor.cep.event.RotationEvent;
import com.cor.cep.subscriber.humidity.HumiCriticalEventSubscriber;
import com.cor.cep.subscriber.humidity.HumiMonitorEventSubscriber;
import com.cor.cep.subscriber.humidity.HumiWarningEventSubscriber;
import com.cor.cep.util.*;
import com.espertech.esper.client.EPStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class HumidityEventHandler {


    /**
     * Logger
     */
    public HumidityEventHandler(){afterPropertiesSet();}


    private static Logger tempLOG = LoggerFactory.getLogger(TemperatureEventHandler.class);

    /**
     * Esper service
     */



    private EPStatement humicriticalEventStatement;
    private EPStatement humiwarningEventStatement;
    private EPStatement humimonitorEventStatement;






    private HumiCriticalEventSubscriber humiCriticalEventSubscriber = new HumiCriticalEventSubscriber();


    private HumiWarningEventSubscriber humiWarningEventSubscriber = new HumiWarningEventSubscriber();


    private HumiMonitorEventSubscriber humiMonitorEventSubscriber = new HumiMonitorEventSubscriber();











    //private EPServiceProvider epService;
    //private EPStatement tempcriticalEventStatement;
    //private EPStatement tempwarningEventStatement;
    //private EPStatement tempmonitorEventStatement;

   /* @Autowired
    @Qualifier("tempCriticalEventSubscriber")
    private StatementSubscriber tempCriticalEventSubscriber;

    @Autowired
    @Qualifier("tempWarningEventSubscriber")
    private StatementSubscriber tempWarningEventSubscriber;

    @Autowired
    @Qualifier("tempMonitorEventSubscriber")
    private StatementSubscriber tempMonitorEventSubscriber;
    */


    /**
     * Configure Esper Statement(s).
     */
    public void initService() {

        tempLOG.debug("Initializing Servcie [humidity] ..");
        epService.initService();
        /*Configuration config = new Configuration();
        config.addEventTypeAutoName("com.cor.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);
         */
        createCriticalHumidityCheckExpression();
        createWarningHumidityCheckExpression();
        createHumidityMonitorExpression();

    }


    /**
     * EPL to check for a sudden critical rise across 4 events, where the last event is 1.5x greater
     * than the first event. This is checking for a sudden, sustained escalating rise in the
     * temperature
     */


    private void createCriticalHumidityCheckExpression() {

        tempLOG.debug("create Critical Humidity Check Expression");
        humicriticalEventStatement = epService.epService.getEPAdministrator().createEPL(humiCriticalEventSubscriber.getStatement());
        humicriticalEventStatement.setSubscriber(humiCriticalEventSubscriber);
    }

    /**
     * EPL to check for 2 consecutive Temperature events over the threshold - if matched, will alert
     * listener.
     */


    private void createWarningHumidityCheckExpression() {

        tempLOG.debug("create Warning Humidity Check Expression");
        humiwarningEventStatement = epService.epService.getEPAdministrator().createEPL(humiWarningEventSubscriber.getStatement());
        humiwarningEventStatement.setSubscriber(humiWarningEventSubscriber);
    }

    /**
     * EPL to monitor the average temperature every 10 seconds. Will call listener on every event.
     */


    private void createHumidityMonitorExpression() {

        tempLOG.debug("create Timed Average Humidity Monitor");
        humimonitorEventStatement = epService.epService.getEPAdministrator().createEPL(humiMonitorEventSubscriber.getStatement());
        humimonitorEventStatement.setSubscriber(humiMonitorEventSubscriber);
    }

    /**
     * Handle the incoming TemperatureEvent.
     */



    public void handle(HumidityEvent event) {



        if(FogToCloudGateway.schedule(event.getPriority(),event.getID()))
        {
            String eventtoSend = event.getID()+" "+event.getPriority()+" "+event.gethumidity()+" "+event.getTime()+" "+event.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {

            tempLOG.debug(event.toString());
            epService.epService.getEPRuntime().sendEvent(event);
            //EventPriorities.eventCountadd();
            LogData.HUMIWrite(Float.toString(event.gethumidity()), System.nanoTime() - ResultReciever.systemStartTime);
            EventsThroughput.humiditycount+=1;

        }



       // tempLOG.debug(event.toString());
        //epService.epService.getEPRuntime().sendEvent(event);
        //EventPriorities.eventCountadd();
        //EventsThroughput.humiditycount+=1;

    }


    public void afterPropertiesSet() {

        tempLOG.debug("Configuring..");
        initService();
    }

}
