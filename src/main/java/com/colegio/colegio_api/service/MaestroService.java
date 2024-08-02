package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Maestro;
import com.colegio.colegio_api.repository.IMaestroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MaestroService implements IMaestroService{

    @Autowired
    private IMaestroRepository maeRepo;
    
    @Override
    public List<Maestro> getMaestro() {
        List <Maestro> listaMaestros= maeRepo.findAll();
        return listaMaestros;      
    }

    @Override
    public Maestro findMaestro(Long legajo) {
        Maestro mae = maeRepo.findById(legajo).orElse(null);
        return mae;    
    }

    @Override
    public void saveMaestro(Maestro maes) {
        maeRepo.save(maes);     
    }

    @Override
    public void deleteMaestro(Long legajo) {
        maeRepo.deleteById(legajo);    
    }

    @Override
    public void editMaestro(Long legajoOriginal, 
                            Long nuevoLegajo, 
                            String nuevoNombre, 
                            String nuevoApellido, 
                            int nuevoDni) {
        
        Maestro mae = this.findMaestro(legajoOriginal);

        mae.setLegajo(nuevoLegajo);
        mae.setNombre(nuevoNombre);
        mae.setApellido(nuevoApellido);
        mae.setDni(nuevoDni);

       this.saveMaestro(mae);    
    }

    @Override
    public void editMaestro(Maestro maes) {
        this.saveMaestro(maes);    
    }
    
}
