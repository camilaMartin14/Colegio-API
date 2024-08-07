package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Maestro;
import com.colegio.colegio_api.service.IMaestroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaestroController {
     @Autowired
    private IMaestroService maeServ;
    
    @GetMapping ("/maestros")
    public List <Maestro> getMaestros(){
        return maeServ.getMaestro();
    }
    
    @PostMapping ("/maestros/crear")
    public String saveMaestro (@RequestBody Maestro mae){
        maeServ.saveMaestro(mae);
        
        return "El maestro se guardó correctamente";
    }
    
    @DeleteMapping("/maestros/eliminar/{legajo}")
    public String deleteMaestro(@PathVariable Long legajo){
        maeServ.deleteMaestro(legajo);
        
        return "El maestro se borró correctamente";
    }
    
    @PutMapping("/maestros/editar")
    public Maestro editMaestro(@RequestBody Maestro mae){
        maeServ.editMaestro(mae);
        
        return maeServ.findMaestro(mae.getLegajo());
    }
}
