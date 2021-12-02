package as.athen.provarecrutamento.model.form;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import as.athen.provarecrutamento.config.validation.cpf.CpfValido;
import as.athen.provarecrutamento.config.validation.sexo.SexoValido;
import as.athen.provarecrutamento.model.Pessoa;
import as.athen.provarecrutamento.model.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaForm {
	
	@NotNull @NotEmpty @Size(min = 4)	
	private String nome;
	@CpfValido	
	private String cpf;
	
	@NotNull @Past
	private LocalDate dataNascimento;
	@DecimalMin("0.4") @DecimalMax("3.0")	
	private double altura;
	
	@DecimalMin("1.0") @DecimalMax("300.0")	
	private double peso;
	
	@SexoValido		
	private String sexo;
	
	public Pessoa converter() {
		return new Pessoa(nome,cpf,dataNascimento,altura,peso,sexo);
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		pessoa.setNome(this.nome);
		pessoa.setCpf(this.cpf);
		pessoa.setDataNascimento(this.dataNascimento);
		pessoa.setNome(this.nome);
		pessoa.setPeso(this.peso);
		pessoa.setAltura(this.altura);
		pessoa.setSexo(Sexo.valueOf(sexo));
		return pessoa;
	}
	
}
