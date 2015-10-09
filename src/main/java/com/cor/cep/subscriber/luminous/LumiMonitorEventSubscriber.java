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
public class LumiMonitorEventSubscriber implements StatementSubscriber {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(LumiMonitorEventSubscriber.class);

    /**
     * {@inheritDoc}
     */
    public String getStatement() {

        // Example of simple EPL with a Time Window
        //return "select avg(luminous) as avg_val from LuminousEvent.win:time_batch(5 sec)";

        return "select a.luminous, avg(a.luminous + b.temperature) as avg_temp "+
        "from pattern [ a=LuminousEvent ->"+
                "b=TemperatureEvent where timer:within(5 sec)].win:time_batch(5 sec)"+
        "having avg(a.luminous + b.temperature) > 350";
    }

    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, Double> eventMap) {

        // average temp over 10 secs
        Double avg = (Double) eventMap.get("avg_temp");
        //LuminousEvent avg = (LuminousEvent) eventMap.get("avg_temp");




        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------");
        sb.append("\n- -----------------------------[MONITOR] Average PLUS LUMINOUS = " + avg);
        sb.append("\n---------------------------------");

        LOG.debug(sb.toString());
    }
}
