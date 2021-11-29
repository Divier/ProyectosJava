/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.EstudianteDAO;
import co.com.institucion.business.model.Estudiante;
import co.com.institucion.business.dto.EstudianteDTO;
import co.com.institucion.business.util.ObjectMapperUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ECM1378G
 */
@Stateless
public class EstudianteFacadeImpl implements IEstudianteFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<EstudianteDTO> getEstudiantes() {

        EstudianteDAO estudianteDAO = new EstudianteDAO(em);
        List<Estudiante> lsEstudiante = estudianteDAO.findAll();
        List<EstudianteDTO> lsEstudianteDTO = ObjectMapperUtil.mapAll(lsEstudiante, EstudianteDTO.class);
        return lsEstudianteDTO;
    }

    @Override
    public EstudianteDTO getEstudiante(Long id) {
        
        EstudianteDAO estudianteDAO = new EstudianteDAO(em);
        Estudiante estudiante = estudianteDAO.find(id);
        EstudianteDTO estudianteDTO = ObjectMapperUtil.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }
    
    @Override
    public void createEstudiante(EstudianteDTO estudianteDTO) {

        EstudianteDAO estudianteDAO = new EstudianteDAO(em);
        Estudiante estudiante = ObjectMapperUtil.map(estudianteDTO, Estudiante.class);
        estudianteDAO.create(estudiante);
    }

    @Override
    public void updateEstudiante(EstudianteDTO estudianteDTO) {

        EstudianteDAO estudianteDAO = new EstudianteDAO(em);
        Estudiante estudiante = ObjectMapperUtil.map(estudianteDTO, Estudiante.class);
        estudianteDAO.update(estudiante);
    }

    @Override
    public void deleteEstudiante(Long id) {
        
        EstudianteDAO estudianteDAO = new EstudianteDAO(em);
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEst(id);
        estudianteDAO.delete(estudiante);
    }
}
