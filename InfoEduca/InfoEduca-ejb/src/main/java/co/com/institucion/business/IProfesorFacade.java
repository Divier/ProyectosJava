/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dto.ProfesorDTO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ECM1378G
 */
@Local
@Remote
public interface IProfesorFacade {

    List<ProfesorDTO> getProfesores();
    
    ProfesorDTO getProfesor(Long id);

    void createProfesor(ProfesorDTO profesorDTO);

    void updateProfesor(ProfesorDTO profesorDTO);

    void deleteProfesor(Long id);
}
