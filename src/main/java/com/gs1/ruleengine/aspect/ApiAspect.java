package com.gs1.ruleengine.aspect;

import com.gs1.ruleengine.model.payload.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Aspect for Specifying the API total execution time
 */
@Slf4j
@Aspect
@Component
public class ApiAspect {
    /**
     * Rest API Http request
     */
    private final HttpServletRequest request;

    /**
     * Inject Http request if exists
     *
     * @param request Rest API Http request
     */
    public ApiAspect(@Autowired(required = false) final HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Pointcut that matches all Web REST endpoints.
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void isRestController() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Pointcut that matches all Spring beans in the application's controllers packages.
     */
    @Pointcut("within(com.gs1.ruleengine.controller..*)")
    public void isController() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Pointcut that matches all the methods that return an API Response instance
     * Or any subtype of it
     */
    @Pointcut("execution(public com.gs1.ruleengine.model.payload.ApiResponse+ *(..))")
    public void returnsApiResponse() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Pointcut that matches RestFul APIs that return API Response
     */
    @Pointcut("isController() && isRestController() && returnsApiResponse()")
    public void isRestAPI() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Advice that Specify the API total execution time.
     *
     * @param joinPoint join point for advice.
     * @return API response with execution time specified.
     * @throws Throwable throws any exception out of the API.
     */
    @Around("isRestAPI()")
    public Object specifyTotalExecutionTime(final ProceedingJoinPoint joinPoint) throws Throwable {
        final LocalDateTime startTime = LocalDateTime.now();
        if (log.isInfoEnabled()) {
            log.info("Enter: {}-- {} | " +
                            "Method: {}() | " +
                            "Start Time: {} | " +
                            "Argument[s]: [{}]", request.getMethod().toUpperCase(), request.getRequestURI(),
                    joinPoint.getSignature().getName(), startTime, joinPoint.getArgs());
        }

        final ApiResponse<?> apiResponse = (ApiResponse<?>) joinPoint.proceed();

        final LocalDateTime endTime = LocalDateTime.now();
        final long executionMilis = Duration.between(startTime, endTime).toMillis();
        apiResponse.setExecutionTime(MessageFormat.format("{0} ms", executionMilis));
        if (log.isInfoEnabled()) {
            log.info("Exit: {}-- {} | " +
                            "Method: {}() | " +
                            "End Time: {} | " +
                            "Total Execution Time: {}ms", request.getMethod().toUpperCase(), request.getRequestURI(),
                    joinPoint.getSignature().getName(), endTime, Duration.between(startTime, endTime).toMillis());
        }
        return apiResponse;
    }
}