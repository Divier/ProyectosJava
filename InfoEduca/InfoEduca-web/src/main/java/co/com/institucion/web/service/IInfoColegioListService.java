/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.web.service;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author ECM1378G
 */
public interface IInfoColegioListService {
    
    public Response getColegio(HttpHeaders headers, Long id);

    public Response getCurso(HttpHeaders headers, Long id);

    public Response getAsignatura(HttpHeaders headers, Long id);

    public Response getRelacion(HttpHeaders headers, Long id);

    public Response getProfesor(HttpHeaders headers, Long id);

    public Response getEstudiante(HttpHeaders headers, Long id);

    public Response getHorario(HttpHeaders headers, Long id);
}
