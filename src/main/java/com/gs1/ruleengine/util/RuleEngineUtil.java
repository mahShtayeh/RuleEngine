package com.gs1.ruleengine.util;

import com.gs1.ruleengine.model.entity.PaymentTransaction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SPEL Expressions Utilities provider class
 *
 * @author Mahmoud Shtayeh
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RuleEngineUtil {
    /**
     * SPEL expressions parser
     */
    private static final ExpressionParser PARSER;

    /**
     * Evaluation context
     */
    private static final StandardEvaluationContext CONTEXT;

    static {
        PARSER = new SpelExpressionParser();
        CONTEXT = new StandardEvaluationContext();
    }

    /**
     * Evaluate if the passed condition matches the passed in transaction
     *
     * @param transaction Transaction to evaluate the condition against
     * @param condition   Condition SPEL expression
     * @return If the transaction matches the condition
     */
    public static boolean evaluateCondition(final PaymentTransaction transaction, final String condition) {
        if (log.isInfoEnabled()) {
            log.info("Evaluate condition: {} against Transaction: {}", condition, transaction);
        }

        CONTEXT.setRootObject(transaction);

        // Boolean.TRUE.equals added to remove Null possibility
        return Boolean.TRUE.equals(PARSER.parseExpression(condition).getValue(CONTEXT, Boolean.class));
    }

    /**
     * Applies the passed in SPEL expression action against specific transaction
     *
     * @param transaction Transaction to apply the action against
     * @param action      Action SPEL expression
     */
    public static void applyAction(final PaymentTransaction transaction, final String action) {
        if (log.isInfoEnabled()) {
            log.info("Apply action: {} against Transaction: {}", action, transaction);
        }

        CONTEXT.setRootObject(transaction);
        PARSER.parseExpression(action).getValue(CONTEXT);
    }
}