package com.cor.cep.subscriber.temperature;

import java.util.Date;
import java.util.Map;

import com.cor.cep.event.AvgTempEvent;
import com.cor.cep.handler.epService;
import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import com.cor.cep.util.FogToCloudGateway;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */

public class TempMonitorEventSubscriber implements UpdateListener {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(TempMonitorEventSubscriber.class);

    /**
     * {@inheritDoc}
     */
    public String getStatement() {

        // Example of simple EPL with a Time Window
        return "select avg(temperature) as avg_val from TemperatureEvent.win:time_batch(5 sec)";
    }


    public void update(EventBean[] newEvents, EventBean[] oldEvents)
    {

         if (newEvents == null)
        {
        return; // ignore old events for events leaving the window
        }

        EventBean theEvent = newEvents[0];

        Double avg = (Double) theEvent.get("avg_val");

        StringBuilder sb = new StringBuilder();
        sb.append("---update event bean----");
        sb.append("\n- [MONITOR] Average Temp = " + avg);
        sb.append("\n---------------------------------");

        LOG.debug(sb.toString());

    }

    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, Double> eventMap) {

        // average temp over 10 secs
        Double avg = eventMap.get("avg_val");

        Date timestamp = new Date();

        AvgTempEvent avgTempEvent = new AvgTempEvent(avg.intValue(), timestamp, EventPriorities.getavgtemp());

        if(FogToCloudGateway.schedule(avgTempEvent.getPriority(),avgTempEvent.getID()))
        {
            String eventtoSend = avgTempEvent.getID()+" "+avgTempEvent.getPriority()+" "+avgTempEvent.getavgtemperature()+" "+avgTempEvent.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {

            //System.out.println("after temp handle");
            LOG.debug(avgTempEvent.toString());


            epService.epService.getEPRuntime().sendEvent(avgTempEvent);
            EventsThroughput.AVGtempcount+=1;

        }



        //epService.epService.getEPRuntime().sendEvent(avgTempEvent);
        //EventsThroughput.AVGtempcount+=1;


        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------");
        sb.append("\n- [MONITOR] Average Temp = " + avg);
        sb.append("\n---------------------------------");

        LOG.debug(sb.toString());
    }
}
