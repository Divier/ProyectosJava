/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Colegio;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class ColegioDAO extends AbstractDAO<Colegio> {

    private EntityManager em;

    public ColegioDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Colegio> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Colegio.findAll", Colegio.class);
        return query.getResultList();
    }

    @Override
    public List<Colegio> find(Colegio entity) {
        
        em.clear();
        StringBuilder sb = new StringBuilder("SELECT c FROM Colegio c WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Colegio.class);
        if(entity.getIdCol() != null) {
            sb.append(" ");
            sb.append("c.idCol = :idCol");
            query.setParameter("idCol", entity.getIdCol());
        }
        if(entity.getNombre() != null || !entity.getNombre().trim().isEmpty()) {
            sb.append(" ");
            sb.append("c.nombre = :nombre");
            query.setParameter("nombre", entity.getNombre());
        }        
        query = em.createQuery(sb.toString(), Colegio.class);
        return query.getResultList();        
    }
    
    @Override
    public Colegio find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Colegio.findById", Colegio.class);
        query.setParameter("id", id);
        Optional<Colegio> opColegio = query.getResultList().stream().findAny();
        if(opColegio.isPresent()) {
            return opColegio.get();
        }
        return null;
    }

    @Override
    public void create(Colegio entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Colegio entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Colegio entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}
