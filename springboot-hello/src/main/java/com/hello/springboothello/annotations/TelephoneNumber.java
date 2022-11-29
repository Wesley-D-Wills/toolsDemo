package com.hello.springboothello.annotations;

import com.hello.springboothello.annotations.validators.TelephoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TelephoneNumberValidator.class)
public @interface TelephoneNumber {
    String message() default "Invalid telephone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
