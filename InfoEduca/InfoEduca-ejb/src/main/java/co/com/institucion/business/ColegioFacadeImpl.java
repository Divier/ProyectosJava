/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.ColegioDAO;
import co.com.institucion.business.dto.ColegioDTO;
import co.com.institucion.business.model.Colegio;
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
public class ColegioFacadeImpl implements IColegioFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<ColegioDTO> getColegios() {

        ColegioDAO colegioDAO = new ColegioDAO(em);
        List<Colegio> lsColegio = colegioDAO.findAll();
        List<ColegioDTO> lsColegioDTO = ObjectMapperUtil.mapAll(lsColegio, ColegioDTO.class);
        return lsColegioDTO;
    }
    
    @Override
    public ColegioDTO getColegio(Long id) {
        
        ColegioDAO colegioDAO = new ColegioDAO(em);
        Colegio colegio = colegioDAO.find(id);
        ColegioDTO colegioDTO = ObjectMapperUtil.map(colegio, ColegioDTO.class);
        return colegioDTO;
    }

    @Override
    public void createColegio(ColegioDTO colegioDTO) {

        ColegioDAO colegioDAO = new ColegioDAO(em);
        Colegio colegio = ObjectMapperUtil.map(colegioDTO, Colegio.class);
        colegioDAO.create(colegio);
    }

    @Override
    public void updateColegio(ColegioDTO colegioDTO) {

        ColegioDAO colegioDAO = new ColegioDAO(em);
        Colegio colegio = ObjectMapperUtil.map(colegioDTO, Colegio.class);
        colegioDAO.update(colegio);
    }

    @Override
    public void deleteColegio(Long id) {

        ColegioDAO colegioDAO = new ColegioDAO(em);
        Colegio colegio = new Colegio();
        colegio.setIdCol(id);
        colegioDAO.delete(colegio);
    }
}
