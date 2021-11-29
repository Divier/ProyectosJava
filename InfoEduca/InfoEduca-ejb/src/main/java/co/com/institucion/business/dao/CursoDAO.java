/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Curso;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class CursoDAO extends AbstractDAO<Curso> {

    private EntityManager em;

    public CursoDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Curso> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Curso.findAll", Curso.class);
        return query.getResultList();
    }

    @Override
    public List<Curso> find(Curso entity) {

        em.clear();
        StringBuilder sb = new StringBuilder("SELECT c FROM Curso c WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Curso.class);
        if(entity.getIdCur() != null) {
            sb.append(" ");
            sb.append("c.idCur = :idCur");
            query.setParameter("idCur", entity.getIdCur());
        }
        if(entity.getGrado() != null) {
            sb.append(" ");
            sb.append("c.grado = :grado");
            query.setParameter("grado", entity.getGrado());
        }  
        if(entity.getSalon() != null || !entity.getSalon().trim().isEmpty()) {
            sb.append(" ");
            sb.append("c.salon = :salon");
            query.setParameter("salon", entity.getSalon());
        } 
        query = em.createQuery(sb.toString(), Curso.class);
        return query.getResultList();
    }
    
    @Override
    public Curso find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Curso.findById", Curso.class);
        query.setParameter("id", id);
        Optional<Curso> opCurso = query.getResultList().stream().findAny();
        if(opCurso.isPresent()) {
            return opCurso.get();
        }
        return null;
    }

    @Override
    public void create(Curso entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Curso entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Curso entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}
