package com.cor.cep.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;


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
