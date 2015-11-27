package com.cor.cep.subscriber.distance;
import com.cor.cep.event.DistanceEvent;
import com.cor.cep.event.EnteredEvent;
import com.cor.cep.event.LuminousEvent;
import com.cor.cep.handler.epService;
import com.cor.cep.util.*;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.espertech.esper.client.*;
import java.util.Map;
/**
 * Created by prashan on 10/23/15.
 */
@Component
public class DistanceWarningEventSubscriber implements UpdateListener {
    private static Logger LOG = LoggerFactory.getLogger(DistanceWarningEventSubscriber.class);
    private static final String WARNING_EVENT_THRESHOLD = "50";
    public String getStatement() {
// Example using 'Match Recognise' syntax.
        String warningEventExpression = "select * from DistanceEvent "
                + "match_recognize ( "
                + " measures A as dist1, B as dist2 "
                + " pattern (A B) "
                + " define "
                + " A as A.distance < " + WARNING_EVENT_THRESHOLD + ", "
                + " B as B.distance < " + WARNING_EVENT_THRESHOLD + ")";
        return warningEventExpression;
    }
    public void update(EventBean[] newEvents, EventBean[] oldEvents)
    {
        System.out.println("[NOTICE] : PERSON ENTERED DETECTED");
    }
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, DistanceEvent> eventMap) {
// if (newEvents == null)
//{
//return; // ignore old events for events leaving the window
//}
//EventBean theEvent = newEvents[0];
// 1st Temperature in the Warning Sequence
        DistanceEvent dist1 = eventMap.get("dist1");
// 2nd Temperature in the Warning Sequence
        DistanceEvent dist2 = eventMap.get("dist2");
        StringBuilder sb = new StringBuilder();
        sb.append("--------------++++++++++++++++++++++++++++++++++++++++---------------");
        sb.append("\n- [NOTICE] : PERSON ENTERED DETECTED = " + dist1 + "," + dist2);
        sb.append("\n----------------++++++++++++++++++++++++++++++++++++++++----------------------------------");
        EnteredEvent event = new EnteredEvent(dist1.getDistance(),dist2.getDistance(),dist1.getTimeOfReading(), EventPriorities.getentered(), System.nanoTime());
//LOG.debug("After person entered");
        if(FogToCloudGateway.schedule(event.getPriority(),event.getID()))
        {
            String eventtoSend = event.getID()+" "+event.getPriority()+" "+event.getDistance1()+" "+event.getDistance2()+" "+event.getTime()+" "+event.getTimeOfReading();
            FogToCloudGateway.sendtoCloud(eventtoSend);
// System.out.println("SENT TO CLOUD: " + eventtoSend);
        }
        else
        {
            epService.epService.getEPRuntime().sendEvent(event);
            System.out.println(event.toString());
            LogData.ENTEWrite(Float.toString(event.getDistance1()), System.nanoTime() - ResultReciever.systemStartTime);
//EventPriorities.eventCountadd();
            EventsThroughput.entered += 1;
            LOG.debug(sb.toString());
        }
//epService.epService.getEPRuntime().sendEvent(event);
//System.out.println(event.toString());
//EventPriorities.eventCountadd();
//EventsThroughput.entered += 1;
// LOG.debug(sb.toString());
    }
}
