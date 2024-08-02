package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Maestro;
import java.util.List;

public interface IMaestroService {
    
    public List <Maestro> getMaestro();
    
    public Maestro findMaestro(Long legajo);
    
    public void saveMaestro(Maestro maes);
    
    public void deleteMaestro(Long legajo);

    public void editMaestro(Long legajoOriginal,
                            Long nuevoLegajo,
                            String nuevoNombre,
                            String nuevoApellido,
                            int nuevoDni);

    public void editMaestro(Maestro maes);
}
