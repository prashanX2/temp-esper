package com.cor.cep.subscriber.humidity;

import com.cor.cep.event.HumidityEvent;
import com.cor.cep.event.LuminousEvent;
import com.cor.cep.event.WarnLumiEvent;
import com.cor.cep.handler.epService;
import com.cor.cep.subscriber.StatementSubscriber;
import com.cor.cep.util.EventPriorities;
import com.cor.cep.util.EventsThroughput;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class HumiWarningEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(HumiWarningEventSubscriber.class);

    /** If 2 consecutive temperature events are greater than this - issue a warning */
    private static final String WARNING_EVENT_THRESHOLD = "200";

    
    /**
     * {@inheritDoc}
     */
    public String getStatement() {

        // Example using 'Match Recognise' syntax.
        String warningEventExpression = "select * from HumidityEvent "
                + "match_recognize ( "
                + "       measures A as temp1, B as temp2 "
                + "       pattern (A B) "
                + "       define "
                + "               A as A.humidity > " + WARNING_EVENT_THRESHOLD + ", "
                + "               B as B.humidity > " + WARNING_EVENT_THRESHOLD + ")";

        return warningEventExpression;
    }


    public void update(EventBean[] newEvents, EventBean[] oldEvents){}
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, HumidityEvent> eventMap) {

        // 1st Temperature in the Warning Sequence
        HumidityEvent temp1 = (HumidityEvent) eventMap.get("temp1");
        // 2nd Temperature in the Warning Sequence
        HumidityEvent temp2 = (HumidityEvent) eventMap.get("temp2");






        //WarnLumiEvent warnLumiEvent = new WarnLumiEvent(temp5.getluminous(), temp5.getTimeOfReading(),EventPriorities.getwarnlumi());
       // epService.epService.getEPRuntime().sendEvent(warnLumiEvent);
       // EventsThroughput.warnlumicount+=1;


        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------");
        sb.append("\n- [WARNING] : HUMIDITY SPIKE DETECTED = " + temp1 + "," + temp2);
        sb.append("\n--------------------------------------------------");

        LOG.debug(sb.toString());
    }
}
