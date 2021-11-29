/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.RelacionDAO;
import co.com.institucion.business.dto.RelacionDTO;
import co.com.institucion.business.model.Relacion;
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
public class RelacionFacadeImpl implements IRelacionFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<RelacionDTO> getRelaciones() {
        
        RelacionDAO relacionDAO = new RelacionDAO(em);
        List<Relacion> lsRelacion = relacionDAO.findAll();
        List<RelacionDTO> lsRelacionDTO = ObjectMapperUtil.mapAll(lsRelacion, RelacionDTO.class);
        return lsRelacionDTO;
    }
    
    @Override
    public RelacionDTO getRelacion(Long id) {
        
        RelacionDAO relacionDAO = new RelacionDAO(em);
        Relacion relacion = relacionDAO.find(id);
        RelacionDTO relacionDTO = ObjectMapperUtil.map(relacion, RelacionDTO.class);
        return relacionDTO;
    }

    @Override
    public void createRelacion(RelacionDTO relacionDTO) {
        
        RelacionDAO relacionDAO = new RelacionDAO(em);
        Relacion relacion = ObjectMapperUtil.map(relacionDTO, Relacion.class);
        relacionDAO.create(relacion);
    }

    @Override
    public void updateRelacion(RelacionDTO relacionDTO) {
        
        RelacionDAO relacionDAO = new RelacionDAO(em);
        Relacion relacion = ObjectMapperUtil.map(relacionDTO, Relacion.class);
        relacionDAO.update(relacion);
    }

    @Override
    public void deleteRelacion(Long id) {
        
        RelacionDAO relacionDAO = new RelacionDAO(em);
        Relacion relacion = new Relacion();
        relacion.setIdRel(id);
        relacionDAO.delete(relacion);
    }
}