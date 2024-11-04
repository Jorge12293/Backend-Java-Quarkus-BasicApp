package org.acme.appdev;

import java.util.logging.Logger;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class AppLifecycleBean {
    
    private static final Logger logger = Logger.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent evt){
        logger.info("The application is starting");
    }
    
    void onStop(){
        logger.info("The application is stop");
    }

}
