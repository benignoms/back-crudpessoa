package as.athen.provarecrutamento.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import as.athen.provarecrutamento.model.Pessoa;
import as.athen.provarecrutamento.model.form.PessoaForm;
import as.athen.provarecrutamento.repository.PessoaRepository;

@Component
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}

	public List<Pessoa> buscarPorNome(String nome) {
		return pessoaRepository.findByNomeContaining(nome);
	}

	public void cadastrar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	public Pessoa buscarPorId(Long id) throws EntityNotFoundException {
		return pessoaRepository.getById(id);
	}

	public Pessoa atualizar(Long id, @Valid PessoaForm pessoaForm) throws EntityNotFoundException {
		Pessoa pessoa = pessoaRepository.getById(id);
		pessoaForm.atualizar(pessoa);
		return pessoa;
	}

	public void remover(Long id) {
		if (!pessoaRepository.existsById(id))
			throw new EntityNotFoundException();
		pessoaRepository.deleteById(id);
	}

}
