package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.service.IAlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
     @Autowired
    private IAlumnoService aluServ;
    
    @GetMapping ("/alumnos")
    public List <Alumno> getAlumnos(){
        return aluServ.getAlumno();
    }
    
    @PostMapping ("/alumnos/crear")
    public String saveAlumno(@RequestBody Alumno alu){
        aluServ.saveAlumno(alu);
        
        return "El alumno se guardó correctamente";
    }
    
    @DeleteMapping("/alumnos/eliminar/{legajo_alumno}")
    public String deleteAlumno(@PathVariable Long legajo){
        aluServ.deleteAlumno(legajo);
        
        return "El alumno se borró correctamente";
    }

    @PutMapping("/alumnos/editar/{legajo_alumno}")
    public Alumno editAlumno (@PathVariable Long legajoOriginal,
            @RequestParam(required = false, name= "legajo") Long nuevoLegajo,
            @RequestParam(required = false, name= "nombre") String nuevoNombre,
            @RequestParam(required = false, name= "apellido") String nuevoApellido,
            @RequestParam(required = false, name= "dni") int nuevoDni,
            @RequestParam(required = false, name= "cuil") int nuevoCuil,
            @RequestParam(required = false, name= "edad") int nuevaEdad,
            @RequestParam(required = false, name= "genero") char nuevoGenero){
            
        aluServ.editAlumno(legajoOriginal,
                            nuevoLegajo,
                            nuevoNombre,
                            nuevoApellido,
                            nuevoDni,
                            nuevoCuil,
                            nuevaEdad,
                            nuevoGenero);
        
        Alumno alu = aluServ.findAlumno(nuevoLegajo);
        
        return alu;
    }
    
    @PutMapping("/alumnos/editar")
    public Alumno editAlumno(@RequestBody Alumno alu){
        aluServ.editAlumno(alu);
        
        return aluServ.findAlumno(alu.getLegajo());
    }
}
