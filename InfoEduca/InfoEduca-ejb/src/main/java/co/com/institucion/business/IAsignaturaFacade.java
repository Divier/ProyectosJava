/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dto.AsignaturaDTO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ECM1378G
 */
@Local
@Remote
public interface IAsignaturaFacade {

    List<AsignaturaDTO> getAsignaturas();
    
    AsignaturaDTO getAsignatura(Long id);

    void createAsignatura(AsignaturaDTO asignaturaDTO);

    void updateAsignatura(AsignaturaDTO asignaturaDTO);

    void deleteAsignatura(Long id);
}
