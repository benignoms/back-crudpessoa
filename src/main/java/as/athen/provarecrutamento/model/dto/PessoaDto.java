package as.athen.provarecrutamento.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import as.athen.provarecrutamento.model.Pessoa;
import as.athen.provarecrutamento.model.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id,cpf,nome,dataNascimento,altura,peso,sexo"})
public class PessoaDto {
			
	@JsonSerialize
	private Long id;
	@JsonSerialize
	private String nome;	
	@JsonSerialize
	private String cpf;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize
	private LocalDate dataNascimento;	
	@JsonSerialize
	private double altura;	
	@JsonSerialize
	private double peso;
	@JsonSerialize	
	private Sexo sexo;		
	
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.altura = pessoa.getAltura();
		this.peso = pessoa.getPeso();
		this.sexo = pessoa.getSexo();
		this.cpf = pessoa.getCpf();		
	}
	
	public static List<PessoaDto> converter(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(PessoaDto::new)
				.collect(Collectors.toList());
	}
}
