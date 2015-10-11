package com.cor.cep.util;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cor.cep.event.AccelerationEvent;
import com.cor.cep.event.GravityEvent;
import com.cor.cep.event.RotationEvent;
import com.cor.cep.event.OrientationEvent;



import com.cor.cep.handler.LuminousEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cor.cep.event.TemperatureEvent;
import com.cor.cep.event.LuminousEvent;
import com.cor.cep.handler.TemperatureEventHandler;
import com.cor.cep.handler.AccelerationEventHandler;
import com.cor.cep.handler.GravityEventHandler;
import com.cor.cep.handler.RotationEventHandler;
import com.cor.cep.handler.OrientationEventHandler;


/**
 * Just a simple class to create a number of Random TemperatureEvents and pass them off to the
 * TemperatureEventHandler.
 */
@Component
public class RandomTemperatureEventGenerator {

    /** Logger */
    private static Logger LOG = LoggerFactory.getLogger(RandomTemperatureEventGenerator.class);

    /** The TemperatureEventHandler - wraps the Esper engine and processes the Events  */
    @Autowired
    private  TemperatureEventHandler temperatureEventHandler;

    @Autowired
    private LuminousEventHandler luminousEventHandler;

    @Autowired
    private AccelerationEventHandler accelerationEventHandler;

    @Autowired
    private GravityEventHandler gravityEventHandler;

    @Autowired
    private RotationEventHandler rotationEventHandler;

    @Autowired
    private OrientationEventHandler orientationEventHandler;

    /**
     * Creates simple random Temperature events and lets the implementation class handle them.
     */
    public void startSendingTemperatureReadings(final long noOfTemperatureEvents) {

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();

        xrayExecutor.submit(new Runnable() {
            public void run() {

                LOG.debug(getStartingMessage());
                
                int count = 0;
                while (count < noOfTemperatureEvents) {


                    Date timestamp = new Date();

                   //
                    
                    TemperatureEvent temp = new TemperatureEvent(IPCServer_H001.getazi(), timestamp);
                    LuminousEvent ve = new LuminousEvent(IPCServer_H001.getlumi(), timestamp);

                    AccelerationEvent accel = new AccelerationEvent(IPCServer_H001.getaccelx(),IPCServer_H001.getaccely(),IPCServer_H001.getaccelz(),timestamp);
                    GravityEvent gravity = new GravityEvent(IPCServer_H001.getgravityx(),IPCServer_H001.getgravityy(),IPCServer_H001.getgravityz(),timestamp);
                    RotationEvent rotation = new RotationEvent(IPCServer_H001.getrotationx(),IPCServer_H001.getrotationy(),IPCServer_H001.getrotationz(),timestamp);
                    OrientationEvent orientation = new OrientationEvent(IPCServer_H001.getazi(),IPCServer_H001.getpitch(),IPCServer_H001.getroll(),timestamp);


                   //
                    temperatureEventHandler.handle(temp);
                    luminousEventHandler.handle(ve);
                    accelerationEventHandler.handle(accel);
                    gravityEventHandler.handle(gravity);
                    rotationEventHandler.handle(rotation);
                    orientationEventHandler.handle(orientation);

                    count++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        LOG.error("Thread Interrupted", e);
                    }
                }

            }
        });
    }

    
    private String getStartingMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n************************************************************");
        sb.append("\n* STARTING - ");
        sb.append("\n* PLEASE WAIT - TEMPERATURES ARE RANDOM SO MAY TAKE");
        sb.append("\n* A WHILE TO SEE WARNING AND CRITICAL EVENTS!");
        sb.append("\n************************************************************\n");
        return sb.toString();
    }
}
