/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Relacion;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class RelacionDAO extends AbstractDAO<Relacion> {

    private EntityManager em;

    public RelacionDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Relacion> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Relacion.findAll", Relacion.class);
        return query.getResultList();
    }

    @Override
    public List<Relacion> find(Relacion entity) {

        em.clear();
        StringBuilder sb = new StringBuilder("SELECT r FROM Relacion r WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Relacion.class);
        if(entity.getIdRel() != null) {
            sb.append(" ");
            sb.append("r.idRel = :idRel");
            query.setParameter("idRel", entity.getIdRel());
        }
        query = em.createQuery(sb.toString(), Relacion.class);
        return query.getResultList();
    }
    
    @Override
    public Relacion find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Relacion.findById", Relacion.class);
        query.setParameter("id", id);
        Optional<Relacion> opRelacion = query.getResultList().stream().findAny();
        if(opRelacion.isPresent()) {
            return opRelacion.get();
        }
        return null;
    }

    @Override
    public void create(Relacion entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Relacion entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Relacion entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}
