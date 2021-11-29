/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author ECM1378G
 * @param <T>
 */
public class ValidatorUtil<T> {

    public T validateRequest(Long id, T type, Class<T> object) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        if (type == null) {
            type = object.newInstance();
        }
        Method[] method = object.getDeclaredMethods();
        method[0].invoke(object, id);
        return type;
    }

    public T validateResponse(T type, Class<T> object) throws InstantiationException, IllegalAccessException {

        if (type == null) {
            type = object.newInstance();
        }
        return type;
    }
}
