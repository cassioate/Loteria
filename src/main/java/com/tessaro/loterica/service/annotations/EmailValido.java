package com.tessaro.loterica.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.apache.commons.lang.StringUtils;

import com.tessaro.loterica.service.validators.EmailValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailValidator.class})
public @interface EmailValido {
	
	String message() default "O email já foi utilizado";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
//    String email() default StringUtils.EMPTY;

}
