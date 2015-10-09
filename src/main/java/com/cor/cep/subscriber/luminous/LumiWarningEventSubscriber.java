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
public class LumiWarningEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(LumiWarningEventSubscriber.class);

    /** If 2 consecutive temperature events are greater than this - issue a warning */
    private static final String WARNING_EVENT_THRESHOLD = "500";

    
    /**
     * {@inheritDoc}
     */
    public String getStatement() {
        
        // Example using 'Match Recognise' syntax.
        String warningEventExpression = "select * from LuminousEvent "
                + "match_recognize ( "
                + "       measures A as temp1, B as temp2 "
                + "       pattern (A B) " 
                + "       define " 
                + "               A as A.luminous > " + WARNING_EVENT_THRESHOLD + ", "
                + "               B as B.luminous > " + WARNING_EVENT_THRESHOLD + ")";
        
        return warningEventExpression;
    }
    
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, LuminousEvent> eventMap) {

        // 1st Temperature in the Warning Sequence
        LuminousEvent temp1 = (LuminousEvent) eventMap.get("temp1");
        // 2nd Temperature in the Warning Sequence
        LuminousEvent temp2 = (LuminousEvent) eventMap.get("temp2");

        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------");
        sb.append("\n- [WARNING] : LUMINOUS SPIKE DETECTED = " + temp1 + "," + temp2);
        sb.append("\n--------------------------------------------------");

        LOG.debug(sb.toString());
    }
}
