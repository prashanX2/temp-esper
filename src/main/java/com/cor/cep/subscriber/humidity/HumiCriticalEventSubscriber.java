package com.cor.cep.subscriber.humidity;

import com.cor.cep.event.HumidityEvent;
import com.cor.cep.event.LuminousEvent;
import com.cor.cep.subscriber.StatementSubscriber;
import com.espertech.esper.client.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class HumiCriticalEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(HumiCriticalEventSubscriber.class);

    /** Used as the minimum starting threshold for a critical event. */
    private static final String CRITICAL_EVENT_THRESHOLD = "100";
    
    /**
     * If the last event in a critical sequence is this much greater than the first - issue a
     * critical alert.
     */
    private static final String CRITICAL_EVENT_MULTIPLIER = "1.5";
    
    /**
     * {@inheritDoc}
     */
    public String getStatement() {
        
        // Example using 'Match Recognise' syntax.
        String crtiticalEventExpression = "select * from HumidityEvent "
                + "match_recognize ( "
                + "       measures A as temp1, B as temp2, C as temp3, D as temp4 "
                + "       pattern (A B C D) "
                + "       define "
                + "               A as A.humidity > " + CRITICAL_EVENT_THRESHOLD + ", "
                + "               B as (A.humidity < B.humidity), "
                + "               C as (B.humidity < C.humidity), "
                + "               D as (C.humidity < D.humidity) and D.humidity > (A.humidity * " + CRITICAL_EVENT_MULTIPLIER + ")" + ")";

        return crtiticalEventExpression;
    }
    public void update(EventBean[] newEvents, EventBean[] oldEvents){}
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, HumidityEvent> eventMap) {

        // 1st Temperature in the Critical Sequence
        HumidityEvent temp1 = (HumidityEvent) eventMap.get("temp1");
        // 2nd Temperature in the Critical Sequence
        HumidityEvent temp2 = (HumidityEvent) eventMap.get("temp2");
        // 3rd Temperature in the Critical Sequence
        HumidityEvent temp3 = (HumidityEvent) eventMap.get("temp3");
        // 4th Temperature in the Critical Sequence
        HumidityEvent temp4 = (HumidityEvent) eventMap.get("temp4");

        StringBuilder sb = new StringBuilder();
        sb.append("***************************************");
        sb.append("\n* [ALERT] : CRITICAL HUMIDITY EVENT DETECTED! ");
        sb.append("\n* " + temp1 + " > " + temp2 + " > " + temp3 + " > " + temp4);
        sb.append("\n***************************************");

        LOG.debug(sb.toString());
    }


}
