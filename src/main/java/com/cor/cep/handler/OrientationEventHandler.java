package com.cor.cep.handler;

import com.cor.cep.event.OrientationEvent;
import com.cor.cep.event.RotationEvent;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class OrientationEventHandler implements InitializingBean {

    /**
     * Logger
     */
    private static Logger tempLOG = LoggerFactory.getLogger(TemperatureEventHandler.class);

    /**
     * Esper service
     */
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

        tempLOG.debug("Initializing Servcie [orientation] ..");
        epService.initService();
        /*Configuration config = new Configuration();
        config.addEventTypeAutoName("com.cor.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);
         */
        // createCriticalTemperatureCheckExpression();
        //createWarningTemperatureCheckExpression();
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

    /**
     * EPL to check for 2 consecutive Temperature events over the threshold - if matched, will alert
     * listener.
     */

    /*
    private void createWarningTemperatureCheckExpression() {

        tempLOG.debug("create Warning Temperature Check Expression");
        tempwarningEventStatement = epService.epService.getEPAdministrator().createEPL(tempWarningEventSubscriber.getStatement());
        tempwarningEventStatement.setSubscriber(tempWarningEventSubscriber);
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



    public void handle(OrientationEvent event) {

        //tempLOG.debug(event.toString());
        epService.epService.getEPRuntime().sendEvent(event);
        //EventPriorities.eventCountadd();
        EventsThroughput.orientationcount+=1;

    }

    @Override
    public void afterPropertiesSet() {

        tempLOG.debug("Configuring..");
        initService();
    }


}
