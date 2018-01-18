package com.redhat.example.validator;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Dependent
public class TestValidator implements ConstraintValidator<TestValidate, String> {
	@Inject Logger log;

    @Override
    public void initialize(TestValidate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
    	log.info("### Validator.isValid() called.");
    	return true;
    }
}