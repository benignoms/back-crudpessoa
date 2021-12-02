package as.athen.provarecrutamento.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import as.athen.provarecrutamento.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id,nome,pesoIdeal"})
public class PesoIdealDto {
	
	@JsonSerialize	
	private Long id;
	@JsonSerialize	
	private String nome;
	@JsonSerialize	
	private double pesoIdeal;	
	
	public PesoIdealDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.pesoIdeal = pessoa.getPesoIdeal();		
	}

}
