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
public interface IInfoColegioListAllService {

    public Response getColegios(HttpHeaders headers);

    public Response getCursos(HttpHeaders headers);

    public Response getAsignaturas(HttpHeaders headers);

    public Response getRelaciones(HttpHeaders headers);

    public Response getProfesores(HttpHeaders headers);

    public Response getEstudiantes(HttpHeaders headers);

    public Response getHorarios(HttpHeaders headers);
}
