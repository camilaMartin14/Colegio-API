package com.colegio.colegio_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.colegio.colegio_api.model.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findAll(Pageable pageable);
}

