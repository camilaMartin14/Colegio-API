package com.colegio.colegio_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

@Getter@Setter
@Entity
public class Maestro implements Specification <Maestro>{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public long legajo;
    public String nombre;
    public String apellido;
    public int dni;

    public Maestro() {
    }

    public Maestro(long legajo, String nombre, String apellido, int dni) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public Predicate toPredicate(Root<Maestro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (nombre != null) {
            predicates.add(cb.equal(root.get("nombre"), nombre));
        }

        if (apellido != null) {
            predicates.add(cb.equal(root.get("apellido"), apellido));
        }


        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
    
}
