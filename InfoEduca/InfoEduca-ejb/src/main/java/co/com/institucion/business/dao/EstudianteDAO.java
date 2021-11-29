/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Estudiante;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class EstudianteDAO extends AbstractDAO<Estudiante> {

    private EntityManager em;

    public EstudianteDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Estudiante> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Estudiante.findAll", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> find(Estudiante entity) {

        em.clear();
        StringBuilder sb = new StringBuilder("SELECT e FROM Estudiante e WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Estudiante.class);
        if(entity.getIdEst() != null) {
            sb.append(" ");
            sb.append("e.idEst = :idEst");
            query.setParameter("idEst", entity.getIdEst());
        }
        if(entity.getNombre() != null || !entity.getNombre().trim().isEmpty()) {
            sb.append(" ");
            sb.append("e.nombre = :nombre");
            query.setParameter("nombre", entity.getNombre());
        }  
        if(entity.getFechaNacimiento() != null) {
            sb.append(" ");
            sb.append("e.fechaNacimiento = :fechaNacimiento");
            query.setParameter("fechaNacimiento", entity.getFechaNacimiento());
        } 
        query = em.createQuery(sb.toString(), Estudiante.class);
        return query.getResultList();
    }
    
    @Override
    public Estudiante find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Estudiante.findById", Estudiante.class);
        query.setParameter("id", id);
        Optional<Estudiante> opEstudiante = query.getResultList().stream().findAny();
        if(opEstudiante.isPresent()) {
            return opEstudiante.get();
        }
        return null;
    }

    @Override
    public void create(Estudiante entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Estudiante entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Estudiante entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}