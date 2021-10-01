package br.com.mariah.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mariah.forum.controller.dto.DetalhesTopicoDto;
import br.com.mariah.forum.controller.dto.TopicoDto;
import br.com.mariah.forum.controller.form.TopicoForm;
import br.com.mariah.forum.modelo.Topico;
import br.com.mariah.forum.repository.CursoRepository;
import br.com.mariah.forum.repository.TopicoRepository;

@RestController
@RequestMapping("topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoDto> lista(String nomeCurso){
		if (nomeCurso == null) {
			List<Topico> list = topicoRepository.findAll();			
			return TopicoDto.converter(list);
		}else {
			List<Topico> list = topicoRepository.findByCursoNome(nomeCurso);			
			return TopicoDto.converter(list);
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder builder) {
		Topico topico = topicoForm.converter(cursoRepository);
		this.topicoRepository.save(topico);
		
		URI uri = builder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	@GetMapping("/{id}")
	public DetalhesTopicoDto detalhar(@PathVariable(name = "id") Long id) {
		Optional<Topico> optTopico = this.topicoRepository.findById(id);
			return optTopico.isPresent()? new DetalhesTopicoDto(optTopico.get()) : null;
	 
		
	}
}

