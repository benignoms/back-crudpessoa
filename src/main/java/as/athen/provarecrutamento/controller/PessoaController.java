package as.athen.provarecrutamento.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import as.athen.provarecrutamento.model.Pessoa;
import as.athen.provarecrutamento.model.dto.PesoIdealDto;
import as.athen.provarecrutamento.model.dto.PessoaDto;
import as.athen.provarecrutamento.model.form.PessoaForm;
import as.athen.provarecrutamento.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Long id) {
		try {
			Pessoa pessoa = pessoaService.buscarPorId(id);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/pesoIdeal/{id}")
	public ResponseEntity<PesoIdealDto> calcularPesoIdeal(@PathVariable Long id) {
		try {
			Pessoa pessoa = pessoaService.buscarPorId(id);
			return ResponseEntity.ok(new PesoIdealDto(pessoa));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<PessoaDto>> listarTodos() {
		List<PessoaDto> pessoasDto = PessoaDto.converter(pessoaService.listarTodos());
		ResponseEntity<List<PessoaDto>> response = ResponseEntity.ok(pessoasDto);
		return response;
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<PessoaDto>> buscarPorNome(String nome) {
		List<PessoaDto> pessoasDto = PessoaDto.converter(pessoaService.buscarPorNome(nome));
		ResponseEntity<List<PessoaDto>> response = ResponseEntity.ok(pessoasDto);
		return response;
	}

	@PostMapping
	public ResponseEntity<List<PessoaDto>> cadastrar(@RequestBody @Valid PessoaForm pessoaForm,
			UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = pessoaForm.converter();
		pessoaService.cadastrar(pessoa);
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
		List<PessoaDto> pessoasDto = PessoaDto.converter(pessoaService.listarTodos());
		ResponseEntity<List<PessoaDto>> response = ResponseEntity.created(uri).body(pessoasDto);
		return response;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<List<PessoaDto>> atualizar(@PathVariable Long id, @RequestBody @Valid PessoaForm pessoaForm) {
		try {
			pessoaService.atualizar(id, pessoaForm);
			List<PessoaDto> pessoasDto = PessoaDto.converter(pessoaService.listarTodos());
			ResponseEntity<List<PessoaDto>> response = ResponseEntity.ok().body(pessoasDto);
			return response;
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<List<PessoaDto>> remover(@PathVariable Long id) {
		try {
			pessoaService.remover(id);
			List<PessoaDto> pessoasDto = PessoaDto.converter(pessoaService.listarTodos());
			return ResponseEntity.ok(pessoasDto);
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}

	}

}
