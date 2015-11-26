package com.cor.cep.handler;


import com.cor.cep.event.DistanceEvent;
import com.cor.cep.event.WarnLumiEvent;
import com.cor.cep.subscriber.EndResult.*;
import com.cor.cep.util.EventsThroughput;
import com.espertech.esper.client.EPStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalEventHandler {

    public FinalEventHandler()
    {
        afterPropertiesSet();

    }

    DistTempSubscriber distTempSubscriber = new DistTempSubscriber();
    DistLumiSubscriber distLumiSubscriber = new DistLumiSubscriber();

    WarnLumiSubscriber warnLumiSubscriber = new WarnLumiSubscriber();
    WarnTempSubscriber warnTempSubscriber = new WarnTempSubscriber();
    WarnHumiSubscriber warnHumiSubscriber = new WarnHumiSubscriber();

    DistWarnTempSubscriber distWarnTempSubscriber = new DistWarnTempSubscriber();


    private EPStatement distTempEventStatement;
    private  EPStatement distLumiEventStatement;

    private EPStatement warnLumiEventStatement;
    private  EPStatement warnTempEventStatement;
    private EPStatement warnHumiEventStatement;

    private  EPStatement distWarnTempEventStatement;

    private static Logger tempLOG = LoggerFactory.getLogger(TemperatureEventHandler.class);

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
        createWarningDistanceTempCheckExpression();
        createWarningDistanceLumiCheckExpression();


        createWarnLumiCheckExpression();
        createWarnTempCheckExpression();
        createWarnHumiCheckExpression();

        createDistWarnTempCheckExpression();


        //createTemperatureMonitorExpression();

    }






    private void createWarningDistanceTempCheckExpression() {

        tempLOG.debug("create Warning Distance Temp alert Check Expression");
        distTempEventStatement = epService.epService.getEPAdministrator().createEPL(distTempSubscriber.getStatement());
        distTempEventStatement.setSubscriber(distTempSubscriber);
    }


    private void createWarningDistanceLumiCheckExpression() {

        tempLOG.debug("create Warning Distance Luminous alert Check Expression");
        distLumiEventStatement = epService.epService.getEPAdministrator().createEPL(distLumiSubscriber.getStatement());
        distLumiEventStatement.setSubscriber(distLumiSubscriber);
    }




    private void createWarnLumiCheckExpression() {

        tempLOG.debug("create Warning alert  Luminous Check Expression");
        warnLumiEventStatement = epService.epService.getEPAdministrator().createEPL(warnLumiSubscriber.getStatement());
        warnLumiEventStatement.setSubscriber(warnLumiSubscriber);
    }



    private void createWarnTempCheckExpression() {

        tempLOG.debug("create Warning alert  Temp Check Expression");
        warnTempEventStatement = epService.epService.getEPAdministrator().createEPL(warnTempSubscriber.getStatement());
        warnTempEventStatement.setSubscriber(warnTempSubscriber);
    }


    private void createWarnHumiCheckExpression() {

        tempLOG.debug("create Warning alert  Luminous Check Expression");
        warnHumiEventStatement = epService.epService.getEPAdministrator().createEPL(warnHumiSubscriber.getStatement());
        warnHumiEventStatement.setSubscriber(warnHumiSubscriber);
    }


    private void  createDistWarnTempCheckExpression() {

        tempLOG.debug("create Warning distance and high temp Check Expression");
        distWarnTempEventStatement = epService.epService.getEPAdministrator().createEPL(distWarnTempSubscriber.getStatement());
        distWarnTempEventStatement.setSubscriber(distWarnTempSubscriber);
    }


    public void handle() {

        //tempLOG.debug(event.toString());
        //epService.epService.getEPRuntime().sendEvent(event);
        //EventPriorities.eventCountadd();
        //EventsThroughput.distancecount += 1;

    }


    public void afterPropertiesSet() {

        tempLOG.debug("Configuring..");
        initService();
    }






}
