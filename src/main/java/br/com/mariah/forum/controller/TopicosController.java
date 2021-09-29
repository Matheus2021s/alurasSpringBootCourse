package br.com.mariah.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariah.forum.controller.dto.TopicoDto;
import br.com.mariah.forum.modelo.Curso;
import br.com.mariah.forum.modelo.Topico;

@RestController
public class TopicosController {


	@RequestMapping("/topicos")
	public List<TopicoDto> lista(){
	
		Curso curso = new Curso("Spring","java");
		Topico topico = new Topico("rest", "topico rest", curso);
		
		return TopicoDto.converter(Arrays.asList(topico,topico, topico));
	}
}

