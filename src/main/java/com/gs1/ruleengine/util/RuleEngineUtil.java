package com.gs1.ruleengine.util;

import com.gs1.ruleengine.model.entity.PaymentTransaction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RuleEngineUtil {
    private static final ExpressionParser PARSER;

    private static final StandardEvaluationContext CONTEXT;

    static {
        PARSER = new SpelExpressionParser();
        CONTEXT = new StandardEvaluationContext();
    }

    public static boolean evaluateCondition(PaymentTransaction transaction, String condition) {
        if (log.isInfoEnabled()) {
            log.info("Evaluate condition: {} against Transaction: {}", condition, transaction);
        }

        CONTEXT.setRootObject(transaction);

        // Boolean.TRUE.equals added to remove Null possibility
        return Boolean.TRUE.equals(PARSER.parseExpression(condition).getValue(CONTEXT, Boolean.class));
    }

    public static void applyAction(PaymentTransaction transaction, String action) {
        if (log.isInfoEnabled()) {
            log.info("Apply action: {} against Transaction: {}", action, transaction);
        }

        CONTEXT.setRootObject(transaction);
        PARSER.parseExpression(action).getValue(CONTEXT);
    }
}