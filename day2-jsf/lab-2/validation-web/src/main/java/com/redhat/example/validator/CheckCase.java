package com.redhat.example.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.redhat.example.constants.MessageRefs;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
public @interface CheckCase {

    String message() default MessageRefs.CHECK_CASE;
    
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    CheckCase.Mode value();

    public enum Mode {
        UPPER ("大文字"),
        LOWER ("小文字");
    	
    	private String label;
    	
    	Mode(String label) {
    		this.label = label;
    	}
    	
    	public String toString() {
    		return label;
    	}
    }
}