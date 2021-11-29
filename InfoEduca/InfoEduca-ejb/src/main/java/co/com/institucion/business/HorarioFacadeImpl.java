/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.HorarioDAO;
import co.com.institucion.business.dto.HorarioDTO;
import co.com.institucion.business.model.Horario;
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
public class HorarioFacadeImpl implements IHorarioFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<HorarioDTO> getHorarios() {

        HorarioDAO horarioDAO = new HorarioDAO(em);
        List<Horario> lsHorario = horarioDAO.findAll();
        List<HorarioDTO> lsHorarioDTO = ObjectMapperUtil.mapAll(lsHorario, HorarioDTO.class);
        return lsHorarioDTO;
    }
    
    @Override
    public HorarioDTO getHorario(Long id) {
        
        HorarioDAO horarioDAO = new HorarioDAO(em);
        Horario horario = horarioDAO.find(id);
        HorarioDTO horarioDTO = ObjectMapperUtil.map(horario, HorarioDTO.class);
        return horarioDTO;
    }

    @Override
    public void createHorario(HorarioDTO horarioDTO) {

        HorarioDAO horarioDAO = new HorarioDAO(em);
        Horario horario = ObjectMapperUtil.map(horarioDTO, Horario.class);
        horarioDAO.create(horario);
    }

    @Override
    public void updateHorario(HorarioDTO horarioDTO) {

        HorarioDAO horarioDAO = new HorarioDAO(em);
        Horario horario = ObjectMapperUtil.map(horarioDTO, Horario.class);
        horarioDAO.update(horario);
    }

    @Override
    public void deleteHorario(Long id) {
        
        HorarioDAO horarioDAO = new HorarioDAO(em);
        Horario horario = new Horario();
        horario.setIdHor(id);
        horarioDAO.delete(horario);
    }
}
