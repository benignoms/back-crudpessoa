package as.athen.provarecrutamento.config.validation.cpf;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CpfValidator.class)
public @interface CpfValido {
	String message() default "valor inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
