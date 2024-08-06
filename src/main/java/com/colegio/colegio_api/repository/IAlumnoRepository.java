package com.colegio.colegio_api.repository;

import com.colegio.colegio_api.model.Alumno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository <Alumno, Long>{
    
    Optional<Alumno> findByNombreAndApellido(String nombre, String apellido);

}
