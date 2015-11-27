package com.cor.cep.subscriber.temperature;

import java.util.Map;

import com.cor.cep.event.WarnLumiEvent;
import com.cor.cep.event.WarnTempEvent;
import com.cor.cep.handler.epService;
import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.util.*;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cor.cep.event.TemperatureEvent;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class TempWarningEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(TempWarningEventSubscriber.class);

    /** If 2 consecutive temperature events are greater than this - issue a warning */
    private static final String WARNING_EVENT_THRESHOLD = "28";

    
    /**
     * {@inheritDoc}
     */
    public String getStatement() {
        
        // Example using 'Match Recognise' syntax.
        String warningEventExpression = "select * from TemperatureEvent "
                + "match_recognize ( "
                + "       measures A as temp1, B as temp2 "
                + "       pattern (A B) " 
                + "       define " 
                + "               A as A.temperature > " + WARNING_EVENT_THRESHOLD + ", "
                + "               B as B.temperature > " + WARNING_EVENT_THRESHOLD + ")";
        
        return warningEventExpression;
    }
    
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(EventBean[] newEvents, EventBean[] oldEvents){}

    public void update(Map<String, TemperatureEvent> eventMap) {

        // 1st Temperature in the Warning Sequence
        TemperatureEvent temp1 = eventMap.get("temp1");
        // 2nd Temperature in the Warning Sequence
        TemperatureEvent temp2 = eventMap.get("temp2");


        WarnTempEvent warnTempEvent = new WarnTempEvent(temp2.getTemperature(), temp2.getTimeOfReading(), EventPriorities.getwarntemp(),System.nanoTime());


        if(FogToCloudGateway.schedule(warnTempEvent.getPriority(),warnTempEvent.getID()))
        {
            String eventtoSend = warnTempEvent.getID()+" "+warnTempEvent.getPriority()+" "+warnTempEvent.getwarntemperature()+" "+warnTempEvent.getTime()+" "+warnTempEvent.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {

            //System.out.println("after temp handle");
            LOG.debug(warnTempEvent.toString());


            epService.epService.getEPRuntime().sendEvent(warnTempEvent);
            if(!FogToCloudGateway.isCloud){
                LogData.WTEMWrite(Float.toString(warnTempEvent.getwarntemperature()), System.nanoTime() - ResultReciever.systemStartTime);
            }else
            {
                String eventtoSend = warnTempEvent.getID()+" "+warnTempEvent.getPriority()+" "+warnTempEvent.getwarntemperature()+" "+warnTempEvent.getTime()+" "+warnTempEvent.getTimeOfReading();

                ResultSender.send(eventtoSend);
            }
            EventsThroughput.warntempcount+=1;

        }


        //epService.epService.getEPRuntime().sendEvent(warnTempEvent);
        //EventsThroughput.warntempcount+=1;


        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------");
        sb.append("\n- [WARNING] : TEMPERATURE SPIKE DETECTED = " + temp1 + "," + temp2);
        sb.append("\n--------------------------------------------------");

        LOG.debug(sb.toString());
    }
}
