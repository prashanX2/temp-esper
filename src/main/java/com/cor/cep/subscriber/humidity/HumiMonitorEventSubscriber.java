package com.cor.cep.subscriber.humidity;

import com.cor.cep.event.AvgHumiEvent;
import com.cor.cep.event.AvgLumiEvent;
import com.cor.cep.handler.epService;
import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import com.cor.cep.util.FogToCloudGateway;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class HumiMonitorEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(HumiMonitorEventSubscriber.class);

    /**
     * {@inheritDoc}
     */
    public String getStatement() {

        // Example of simple EPL with a Time Window
        //return "select avg(luminous) as avg_val from LuminousEvent.win:time_batch(5 sec)";




        return "select avg(humidity) as avg_val from HumidityEvent.win:time_batch(5 sec)";
    }

    public void update(EventBean[] newEvents, EventBean[] oldEvents){}
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, Double> eventMap) {

        // average temp over 10 secs
        Double avg = eventMap.get("avg_val");
        //LuminousEvent avg = (LuminousEvent) eventMap.get("avg_temp");

        Date timestamp = new Date();

        AvgHumiEvent avgHumiEvent = new AvgHumiEvent(avg.intValue(), timestamp, EventPriorities.getavghumi());


        if(FogToCloudGateway.schedule(avgHumiEvent.getPriority(),avgHumiEvent.getID()))
        {
            String eventtoSend = avgHumiEvent.getID()+" "+avgHumiEvent.getPriority()+" "+avgHumiEvent.getavghumidity()+" "+avgHumiEvent.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {

            //System.out.println("after temp handle");
            LOG.debug(avgHumiEvent.toString());
            epService.epService.getEPRuntime().sendEvent(avgHumiEvent);
            EventsThroughput.AVGhumicount+=1;

        }







       // epService.epService.getEPRuntime().sendEvent(avgHumiEvent);
       // EventsThroughput.AVGhumicount+=1;

        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------");
        sb.append("\n- ----------------------------------------------------------[MONITOR] Average Humidity = " + avg);
        sb.append("\n---------------------------------");

        LOG.debug(sb.toString());
    }
}
