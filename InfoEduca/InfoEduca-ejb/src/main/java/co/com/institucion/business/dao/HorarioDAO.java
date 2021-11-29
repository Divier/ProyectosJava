/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import co.com.institucion.business.model.Horario;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ECM1378G
 */
public class HorarioDAO extends AbstractDAO<Horario> {

    private EntityManager em;

    public HorarioDAO(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<Horario> findAll() {

        em.clear();
        Query query = em.createNamedQuery("Horario.findAll", Horario.class);
        return query.getResultList();
    }

    @Override
    public List<Horario> find(Horario entity) {

        em.clear();
        StringBuilder sb = new StringBuilder("SELECT h FROM Horario h WHERE 1 = 1");
        Query query = em.createQuery(sb.toString(), Horario.class);
        if (entity.getIdHor() != null) {
            sb.append(" ");
            sb.append("h.idHor = :idHor");
            query.setParameter("idHor", entity.getIdHor());
        }
        if (entity.getDia() != null && !entity.getDia().trim().isEmpty()) {
            sb.append(" ");
            sb.append("h.dia = :dia");
            query.setParameter("dia", entity.getDia());
        }
        if (entity.getHora() != null) {
            sb.append(" ");
            sb.append("h.hora = :hora");
            query.setParameter("hora", entity.getHora());
        }
        query = em.createQuery(sb.toString(), Horario.class);
        return query.getResultList();
    }
    
    @Override
    public Horario find(Long id) {

        em.clear();
        Query query = em.createNamedQuery("Horario.findById", Horario.class);
        query.setParameter("id", id);
        Optional<Horario> opHorario = query.getResultList().stream().findAny();
        if(opHorario.isPresent()) {
            return opHorario.get();
        }
        return null;
    }

    @Override
    public void create(Horario entity) {

        em.persist(entity);
        em.flush();
    }

    @Override
    public void update(Horario entity) {

        em.merge(entity);
        em.flush();
    }

    @Override
    public void delete(Horario entity) {

        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.flush();
    }
}
