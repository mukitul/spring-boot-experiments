package com.app.springdataexp.validationexp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CustomDayValidator.class)
public @interface ValidDayCount {
    String message() default "Invalid Day Count";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}