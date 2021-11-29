/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dto.EstudianteDTO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ECM1378G
 */
@Local
@Remote
public interface IEstudianteFacade {

    List<EstudianteDTO> getEstudiantes();
    
    EstudianteDTO getEstudiante(Long id);

    void createEstudiante(EstudianteDTO estudianteDTO);

    void updateEstudiante(EstudianteDTO estudianteDTO);

    void deleteEstudiante(Long id);
}
