package com.colegio.colegio_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.colegio.colegio_api.model.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
    
}
