package br.com.mariah.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariah.forum.controller.dto.TopicoDto;
import br.com.mariah.forum.modelo.Topico;
import br.com.mariah.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso){
		if (nomeCurso == null) {
			List<Topico> list = topicoRepository.findAll();			
			return TopicoDto.converter(list);
		}else {
			List<Topico> list = topicoRepository.findByCursoNome(nomeCurso);			
			return TopicoDto.converter(list);
		}
	}
}

