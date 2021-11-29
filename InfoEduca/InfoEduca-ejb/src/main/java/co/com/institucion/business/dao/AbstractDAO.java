/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dao;

import java.util.List;

/**
 *
 * @author ECM1378G
 * @param <T>
 */
public abstract class AbstractDAO<T> {

    public abstract List<T> findAll();

    public abstract List<T> find(T t);
    
    public abstract T find(Long id);

    public abstract void create(T t);

    public abstract void update(T t);

    public abstract void delete(T t);
}
