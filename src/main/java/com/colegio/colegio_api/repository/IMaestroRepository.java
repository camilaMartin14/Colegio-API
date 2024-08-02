package com.colegio.colegio_api.repository;

import com.colegio.colegio_api.model.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaestroRepository extends JpaRepository <Maestro, Long> {
    
}
