package as.athen.provarecrutamento.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import as.athen.provarecrutamento.config.validation.cpf.CpfFormatter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(name = "data_nasc")
	private LocalDate dataNascimento;	
	private String cpf;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private double altura;
	private double peso;
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento, double altura, double peso, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.peso = peso;
		this.sexo = Sexo.valueOf(sexo);
	}

	/**
	 * Calcula qual deveria se o peso ideal de acordo com a altura da Pessoa
	 * @return retorna o peso ideal da Pessoa
	 */
	public double getPesoIdeal() {
		return sexo.calcularPesoIdeal(altura);
	}

	public String getCPFFormatado() {		
		return CpfFormatter.formatarCpf(this.cpf);
	}	
}
