package com.colegio.colegio_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.colegio.colegio_api.model.Alumno;
import java.util.List;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
    //Page<Alumno> findAll(Pageable pageable);
    List <Alumno> findByNombre(String nombre);
}
