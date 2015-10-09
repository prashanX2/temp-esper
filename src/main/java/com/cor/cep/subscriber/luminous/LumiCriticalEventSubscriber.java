package com.cor.cep.subscriber.luminous;

import com.cor.cep.event.LuminousEvent;
import com.cor.cep.subscriber.StatementSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class LumiCriticalEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(LumiCriticalEventSubscriber.class);

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
        String crtiticalEventExpression = "select * from LuminousEvent "
                + "match_recognize ( "
                + "       measures A as temp1, B as temp2, C as temp3, D as temp4 "
                + "       pattern (A B C D) "
                + "       define "
                + "               A as A.luminous > " + CRITICAL_EVENT_THRESHOLD + ", "
                + "               B as (A.luminous < B.luminous), "
                + "               C as (B.luminous < C.luminous), "
                + "               D as (C.luminous < D.luminous) and D.luminous > (A.luminous * " + CRITICAL_EVENT_MULTIPLIER + ")" + ")";

        return crtiticalEventExpression;
    }

    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, LuminousEvent> eventMap) {

        // 1st Temperature in the Critical Sequence
        LuminousEvent temp1 = (LuminousEvent) eventMap.get("temp1");
        // 2nd Temperature in the Critical Sequence
        LuminousEvent temp2 = (LuminousEvent) eventMap.get("temp2");
        // 3rd Temperature in the Critical Sequence
        LuminousEvent temp3 = (LuminousEvent) eventMap.get("temp3");
        // 4th Temperature in the Critical Sequence
        LuminousEvent temp4 = (LuminousEvent) eventMap.get("temp4");

        StringBuilder sb = new StringBuilder();
        sb.append("***************************************");
        sb.append("\n* [ALERT] : CRITICAL LUMINOUS EVENT DETECTED! ");
        sb.append("\n* " + temp1 + " > " + temp2 + " > " + temp3 + " > " + temp4);
        sb.append("\n***************************************");

        LOG.debug(sb.toString());
    }


}
