package br.com.mariah.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mariah.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
