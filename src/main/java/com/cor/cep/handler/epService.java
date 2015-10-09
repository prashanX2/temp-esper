package com.cor.cep.handler;

import com.cor.cep.event.LuminousEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cor.cep.event.TemperatureEvent;
import com.cor.cep.subscriber.StatementSubscriber;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;


public final class epService {


    public static Logger LOG = LoggerFactory.getLogger(LuminousEventHandler.class);
    public static EPServiceProvider epService;
    public static boolean initialized = false;

    public static void initService()
    {

        if(initialized==false)
        {
            LOG.debug("Initializing Servcie [gen] ..");
            Configuration config = new Configuration();
            config.addEventTypeAutoName("com.cor.cep.event");
            epService = EPServiceProviderManager.getDefaultProvider(config);
            initialized = true;

        }

    }




}
