package com.gs1.ruleengine;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Rule Engine Application main class
 *
 * @author Mahmoud Shtayeh
 */
@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RuleEngineApplication {
    /**
     * Application entry point
     *
     * @param args Command line passed in arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(RuleEngineApplication.class, args);
    }
}