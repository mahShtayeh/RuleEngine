package com.gs1.ruleengine.validator;

import com.gs1.ruleengine.validator.annotation.EnumValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

/**
 * Enum value annotation validator
 *
 * @author Mahmoud Shtayeh
 */
@NoArgsConstructor
public class EnumValueValidator implements ConstraintValidator<EnumValue, CharSequence> {
    /**
     * List of Enum class accepted values
     */
    private List<String> acceptedValues;

    /**
     * Initialize the accepted list out of the Enum values
     *
     * @param annotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(final EnumValue annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::toString)
                .toList();
    }

    /**
     * Validate the passed value against the accepted list
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return If passed value is accepted
     */
    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
        return value == null || value.isEmpty() || acceptedValues.contains(value.toString());
    }
}