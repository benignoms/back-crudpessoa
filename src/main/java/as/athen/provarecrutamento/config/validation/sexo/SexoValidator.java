package as.athen.provarecrutamento.config.validation.sexo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import as.athen.provarecrutamento.model.Sexo;

public class SexoValidator implements ConstraintValidator<SexoValido, String> {

	@Override
	public boolean isValid(String valor, ConstraintValidatorContext context) {		
		List<String> valoresValidos = Arrays.asList(Sexo.values())
				.stream()
				.map(s -> s.name())
				.collect(Collectors.toList());
		return valoresValidos.contains(valor);	
	}

}
