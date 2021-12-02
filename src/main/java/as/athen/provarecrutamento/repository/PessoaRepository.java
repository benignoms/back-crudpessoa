package as.athen.provarecrutamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import as.athen.provarecrutamento.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	
	List<Pessoa> findByNomeContaining(String nome);

}
