package org.amarques.spring.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class used to launch Spring Boot application
 * 
 * @author alejandro
 *
 */
@SpringBootApplication
public class Application {

    /**
     * Method used to launch Spring Boot application
     * 
     * @param args	Spring Boot application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}