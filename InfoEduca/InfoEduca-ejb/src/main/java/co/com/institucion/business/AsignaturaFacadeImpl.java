/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.AsignaturaDAO;
import co.com.institucion.business.dto.AsignaturaDTO;
import co.com.institucion.business.model.Asignatura;
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
public class AsignaturaFacadeImpl implements IAsignaturaFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<AsignaturaDTO> getAsignaturas() {

        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(em);
        List<Asignatura> lsAsignatura = asignaturaDAO.findAll();
        List<AsignaturaDTO> lsAsignaturaDTO = ObjectMapperUtil.mapAll(lsAsignatura, AsignaturaDTO.class);
        return lsAsignaturaDTO;
    }
    
    @Override
    public AsignaturaDTO getAsignatura(Long id) {
        
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(em);
        Asignatura asignatura = asignaturaDAO.find(id);
        AsignaturaDTO asignaturaDTO = ObjectMapperUtil.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;
    }

    @Override
    public void createAsignatura(AsignaturaDTO asignaturaDTO) {

        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(em);
        Asignatura asignatura = ObjectMapperUtil.map(asignaturaDTO, Asignatura.class);
        asignaturaDAO.create(asignatura);
    }

    @Override
    public void updateAsignatura(AsignaturaDTO asignaturaDTO) {

        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(em);
        Asignatura asignatura = ObjectMapperUtil.map(asignaturaDTO, Asignatura.class);
        asignaturaDAO.update(asignatura);
    }

    @Override
    public void deleteAsignatura(Long id) {

        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(em);
        Asignatura asignatura = new Asignatura();
        asignatura.setIdAsg(id);
        asignaturaDAO.delete(asignatura);
    }
}
