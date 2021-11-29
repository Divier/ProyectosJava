/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Asignatura;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class AsignaturaDAO extends AbstractDAO<Asignatura> {

    private EntityManager em;

    public AsignaturaDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Asignatura> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Asignatura.findAll", Asignatura.class);
        return query.getResultList();
    }

    @Override
    public List<Asignatura> find(Asignatura entity) {

        em.clear();
        StringBuilder sb = new StringBuilder("SELECT a FROM Asignatura a WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Asignatura.class);
        if(entity.getIdAsg() != null) {
            sb.append(" ");
            sb.append("a.idAsg = :idPrf");
            query.setParameter("idAsg", entity.getIdAsg());
        }
        if(entity.getNombre() != null || !entity.getNombre().trim().isEmpty()) {
            sb.append(" ");
            sb.append("a.nombre = :nombre");
            query.setParameter("nombre", entity.getNombre());
        }  
        if(entity.getFechaDesde() != null) {
            sb.append(" ");
            sb.append("a.fechaDesde = :fechaDesde");
            query.setParameter("fechaDesde", entity.getFechaDesde());
        } 
        if(entity.getFechaHasta() != null) {
            sb.append(" ");
            sb.append("a.fechaHasta = :fechaHasta");
            query.setParameter("fechaHasta", entity.getFechaHasta());
        } 
        query = em.createQuery(sb.toString(), Asignatura.class);
        return query.getResultList();
    }
    
    @Override
    public Asignatura find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Asignatura.findById", Asignatura.class);
        query.setParameter("id", id);
        Optional<Asignatura> opAsignatura = query.getResultList().stream().findAny();
        if(opAsignatura.isPresent()) {
            return opAsignatura.get();
        }
        return null;
    }

    @Override
    public void create(Asignatura entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Asignatura entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Asignatura entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}
