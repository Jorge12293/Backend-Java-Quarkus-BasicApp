package org.acme.appdev;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CustomMain {
    
    public static void main(String[] args) {
        System.out.println("Running main...........");
        Quarkus.run(CustomApp.class,args);
    }
    
    public static class CustomApp implements QuarkusApplication{

        @Override
        public int run(String... args) throws Exception {
            System.out.println("Running CustomApp...........");
            Quarkus.waitForExit();
            return 0;
        }
        
    }
}
