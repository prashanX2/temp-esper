package com.cor.cep.subscriber.EndResult;


import com.cor.cep.subscriber.StatementSubscriber;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class WarnHumiSubscriber implements StatementSubscriber {

    private static Logger LOG = LoggerFactory.getLogger(WarnHumiSubscriber.class);

    public String getStatement() {

        // Example using 'Match Recognise' syntax.

        String warningEventExpression = "select count(*) as cnt from WarnHumiEvent.win:time(2 sec)";

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


    public void update(Map<String, Double> eventMap) {



        System.out.println("################################################");
        System.out.println("HUMIDITY LEVELS ARE HIGH TAKE ACTION");
        System.out.println("################################################");


    }
}
