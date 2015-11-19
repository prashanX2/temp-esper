package com.cor.cep.subscriber.luminous;

import com.cor.cep.event.LuminousEvent;
import com.cor.cep.event.WarnLumiEvent;
import com.cor.cep.handler.epService;
import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import com.cor.cep.util.FogToCloudGateway;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class LumiWarningEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(LumiWarningEventSubscriber.class);

    /** If 2 consecutive temperature events are greater than this - issue a warning */
    private static final String WARNING_EVENT_THRESHOLD = "200";

    
    /**
     * {@inheritDoc}
     */
    public String getStatement() {
        
        // Example using 'Match Recognise' syntax.
        String warningEventExpression = "select * from LuminousEvent "
                + "match_recognize ( "
                + "       measures A as temp1, B as temp2, C as temp3, D as temp4, E as temp5 "
                + "       pattern (A B C D E) "
                + "       define " 
                + "               A as A.luminous > " + WARNING_EVENT_THRESHOLD + ", "
                + "               B as B.luminous > "+  WARNING_EVENT_THRESHOLD + ", "
                + "               C as C.luminous > "+  WARNING_EVENT_THRESHOLD + ", "
                + "               D as D.luminous > "+  WARNING_EVENT_THRESHOLD + ", "
                + "               E as E.luminous > " + WARNING_EVENT_THRESHOLD + ")";
        
        return warningEventExpression;
    }


    public void update(EventBean[] newEvents, EventBean[] oldEvents){}
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, LuminousEvent> eventMap) {

        // 1st Temperature in the Warning Sequence
        LuminousEvent temp1 = (LuminousEvent) eventMap.get("temp1");
        // 2nd Temperature in the Warning Sequence
        LuminousEvent temp2 = (LuminousEvent) eventMap.get("temp2");

        LuminousEvent temp3 = (LuminousEvent) eventMap.get("temp3");
        LuminousEvent temp4 = (LuminousEvent) eventMap.get("temp4");
        LuminousEvent temp5 = (LuminousEvent) eventMap.get("temp5");




        WarnLumiEvent warnLumiEvent = new WarnLumiEvent(temp5.getluminous(), temp5.getTimeOfReading(),EventPriorities.getwarnlumi());

        if(FogToCloudGateway.schedule(warnLumiEvent.getPriority()))
        {
            String eventtoSend = warnLumiEvent.getID()+" "+warnLumiEvent.getPriority()+" "+warnLumiEvent.getwarnluminous()+" "+warnLumiEvent.getTimeOfReading();

            FogToCloudGateway.sendtoCloud(eventtoSend);

            // System.out.println("SENT TO CLOUD: " + eventtoSend);

        }
        else
        {

            //System.out.println("after temp handle");
            LOG.debug(warnLumiEvent.toString());


            epService.epService.getEPRuntime().sendEvent(warnLumiEvent);
            EventsThroughput.warnlumicount+=1;

        }




        //epService.epService.getEPRuntime().sendEvent(warnLumiEvent);
        //EventsThroughput.warnlumicount+=1;


        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------");
        sb.append("\n- [WARNING] : LUMINOUS SPIKE DETECTED = " + temp1 + "," + temp2);
        sb.append("\n--------------------------------------------------");

        LOG.debug(sb.toString());
    }
}
