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
public interface IInfoColegioDelService {

    public Response deleteColegio(HttpHeaders headers, Long id);

    public Response deleteCurso(HttpHeaders headers, Long id);

    public Response deleteAsignatura(HttpHeaders headers, Long id);

    public Response deleteRelacion(HttpHeaders headers, Long id);

    public Response deleteProfesor(HttpHeaders headers, Long id);

    public Response deleteEstudiante(HttpHeaders headers, Long id);

    public Response deleteHorario(HttpHeaders headers, Long id);
}
