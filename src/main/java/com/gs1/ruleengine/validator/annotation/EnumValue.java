package com.gs1.ruleengine.validator.annotation;

import com.gs1.ruleengine.validator.EnumValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface EnumValue {
    /**
     * Enum class
     *
     * @return Enum class
     */
    @SuppressWarnings("squid:S1452")
    Class<? extends Enum<?>> enumClass();

    /**
     * Error message
     *
     * @return Validation error message
     */
    String message() default "INVALID_VALUE";

    /**
     * Validation group classes
     *
     * @return Validation group classes
     */
    Class<?>[] groups() default {};

    /**
     * Validation extendable payload
     *
     * @return Validation extendable payload
     */
    Class<? extends Payload>[] payload() default {};
}