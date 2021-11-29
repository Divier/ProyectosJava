/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business;

import co.com.institucion.business.dao.CursoDAO;
import co.com.institucion.business.dto.CursoDTO;
import co.com.institucion.business.model.Curso;
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
public class CursoFacadeImpl implements ICursoFacade {

    @PersistenceContext(unitName = "MiColegio_PU")
    private EntityManager em;

    @Override
    public List<CursoDTO> getCursos() {

        CursoDAO cursoDAO = new CursoDAO(em);
        List<Curso> lsCurso = cursoDAO.findAll();
        List<CursoDTO> lsCursoDTO = ObjectMapperUtil.mapAll(lsCurso, CursoDTO.class);
        return lsCursoDTO;
    }
    
    @Override
    public CursoDTO getCurso(Long id) {
        
        CursoDAO cursoDAO = new CursoDAO(em);
        Curso curso = cursoDAO.find(id);
        CursoDTO cursoDTO = ObjectMapperUtil.map(curso, CursoDTO.class);
        return cursoDTO;
    }

    @Override
    public void createCurso(CursoDTO cursoDTO) {

        CursoDAO cursoDAO = new CursoDAO(em);
        Curso curso = ObjectMapperUtil.map(cursoDTO, Curso.class);
        cursoDAO.create(curso);
    }

    @Override
    public void updateCurso(CursoDTO cursoDTO) {

        CursoDAO cursoDAO = new CursoDAO(em);
        Curso curso = ObjectMapperUtil.map(cursoDTO, Curso.class);
        cursoDAO.update(curso);
    }

    @Override
    public void deleteCurso(Long id) {

        CursoDAO cursoDAO = new CursoDAO(em);
        Curso curso = new Curso();
        curso.setIdCur(id);
        cursoDAO.delete(curso);
    }
}
