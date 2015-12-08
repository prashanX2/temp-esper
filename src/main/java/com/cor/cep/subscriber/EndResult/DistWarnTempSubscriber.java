package com.cor.cep.subscriber.EndResult;

import com.cor.cep.event.DistanceEvent;

import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.util.EventsThroughput;
import com.cor.cep.util.FogToCloudGateway;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;


public class DistWarnTempSubscriber implements StatementSubscriber {

    private static Logger LOG = LoggerFactory.getLogger(DistTempSubscriber.class);

    public String getStatement() {

        // Example using 'Match Recognise' syntax.

        String warningEventExpression = "select a.distance1 , b.warntemperature "+
                "from pattern [every a=EnteredEvent ->"+
                "b=WarnTempEvent where timer:within(2 sec)].win:time_batch(2 sec)"+
                "having b.warntemperature > 28";

        return warningEventExpression;
    }

    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {


       /*if (newEvents == null)
        {
        return; // ignore old events for events leaving the window
        }

        EventBean theEvent = newEvents[0];

       DistanceEvent dist1 = (DistanceEvent) theEvent.get("dist1");
        // 2nd Temperature in the Warning Sequence
        DistanceEvent dist2 = (DistanceEvent) theEvent.get("dist2");

        StringBuilder sb = new StringBuilder();
        sb.append("--------------++++++++++++++++++++++++++++++++++++++++---------------");
        sb.append("\n- [NOTICE] : PERSON ENTERED DETECTED = " + dist1 + "," + dist2);
        sb.append("\n----------------++++++++++++++++++++++++++++++++++++++++----------------------------------");

        LOG.debug(sb.toString());
        */
    }


    public void update(Map<String, Double> eventMap)
    {
        EventsThroughput.distwarntempcount++;


        if(FogToCloudGateway.isCloud)
        {
            EventsThroughput.cdistwarntempcount++;
        }
        else
        {
            EventsThroughput.ldistwarntempcount++;

        }

        System.out.println("################################################");
        System.out.println("EXIT AT ONCE TEMPERATURE LEVELS TOO HIGH");
        System.out.println("################################################");

    }

}
