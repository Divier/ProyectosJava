/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Profesor;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class ProfesorDAO extends AbstractDAO<Profesor> {

    private EntityManager em;

    public ProfesorDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Profesor> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Profesor.findAll", Profesor.class);
        return query.getResultList();
    }

    @Override
    public List<Profesor> find(Profesor entity) {

        em.clear();
        StringBuilder sb = new StringBuilder("SELECT p FROM Profesor p WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Profesor.class);
        if(entity.getIdPrf() != null) {
            sb.append(" ");
            sb.append("p.idPrf = :idPrf");
            query.setParameter("idPrf", entity.getIdPrf());
        }
        if(entity.getNombre() != null || !entity.getNombre().trim().isEmpty()) {
            sb.append(" ");
            sb.append("p.nombre = :nombre");
            query.setParameter("nombre", entity.getNombre());
        }  
        if(entity.getSalario() != null) {
            sb.append(" ");
            sb.append("p.salario = :salario");
            query.setParameter("salario", entity.getSalario());
        } 
        query = em.createQuery(sb.toString(), Profesor.class);
        return query.getResultList();
    }
    
    @Override
    public Profesor find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Profesor.findById", Profesor.class);
        query.setParameter("id", id);
        Optional<Profesor> opProfesor = query.getResultList().stream().findAny();
        if(opProfesor.isPresent()) {
            return opProfesor.get();
        }
        return null;
    }

    @Override
    public void create(Profesor entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Profesor entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Profesor entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}
