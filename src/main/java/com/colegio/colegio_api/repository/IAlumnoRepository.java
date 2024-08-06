package com.colegio.colegio_api.repository;

import com.colegio.colegio_api.model.Alumno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository <Alumno, Long>{
    
    Optional<Alumno> findAlumnoNombreApellido(String nombre, String apellido);

}
