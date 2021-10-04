package br.com.mariah.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mariah.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	Page<Topico> findByCursoNome(String nomeCurso, PageRequest paginacao);

}
