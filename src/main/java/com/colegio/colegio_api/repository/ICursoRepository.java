package com.colegio.colegio_api.repository;

import com.colegio.colegio_api.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository <Curso, Long>{
    
}
