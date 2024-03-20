package br.com.fiap.smartfrango.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoRotinaValidator.class)
public @interface TipoRotina {
    String message() default "{rotina.tipo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
