/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.ProfesorDAO;
import co.com.institucion.business.model.Profesor;
import co.com.institucion.business.dto.ProfesorDTO;
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
public class ProfesorFacadeImpl implements IProfesorFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<ProfesorDTO> getProfesores() {

        ProfesorDAO profesorDAO = new ProfesorDAO(em);
        List<Profesor> lsProfesor = profesorDAO.findAll();
        List<ProfesorDTO> lsProfesorDTO = ObjectMapperUtil.mapAll(lsProfesor, ProfesorDTO.class);
        return lsProfesorDTO;
    }

    @Override
    public ProfesorDTO getProfesor(Long id) {
        
        ProfesorDAO profesorDAO = new ProfesorDAO(em);
        Profesor profesor = profesorDAO.find(id);
        ProfesorDTO profesorDTO = ObjectMapperUtil.map(profesor, ProfesorDTO.class);
        return profesorDTO;
    }
    
    @Override
    public void createProfesor(ProfesorDTO profesorDTO) {

        ProfesorDAO profesorDAO = new ProfesorDAO(em);
        Profesor profesor = ObjectMapperUtil.map(profesorDTO, Profesor.class);
        profesorDAO.create(profesor);
    }

    @Override
    public void updateProfesor(ProfesorDTO profesorDTO) {

        ProfesorDAO profesorDAO = new ProfesorDAO(em);
        Profesor profesor = ObjectMapperUtil.map(profesorDTO, Profesor.class);
        profesorDAO.update(profesor);
    }

    @Override
    public void deleteProfesor(Long id) {
        
        ProfesorDAO profesorDAO = new ProfesorDAO(em);
        Profesor profesor = new Profesor();
        profesor.setIdPrf(id);
        profesorDAO.delete(profesor);
    }
}
