/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dto.CursoDTO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ECM1378G
 */
@Local
@Remote
public interface ICursoFacade {

    List<CursoDTO> getCursos();
    
    CursoDTO getCurso(Long id);

    void createCurso(CursoDTO cursoDTO);

    void updateCurso(CursoDTO cursoDTO);

    void deleteCurso(Long id);
}
