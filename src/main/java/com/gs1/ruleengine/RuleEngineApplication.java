package com.gs1.ruleengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Rule Engine Application main class
 *
 * @author Mahmoud Shtayeh
 */
@SpringBootApplication
public class RuleEngineApplication {
    /**
     * Application entry point
     *
     * @param args Command line passed in arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RuleEngineApplication.class, args);
    }
}