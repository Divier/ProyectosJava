/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.web.service;

import co.com.institucion.business.IAsignaturaFacade;
import co.com.institucion.business.IColegioFacade;
import co.com.institucion.business.ICursoFacade;
import co.com.institucion.business.IEstudianteFacade;
import co.com.institucion.business.IHorarioFacade;
import co.com.institucion.business.IProfesorFacade;
import co.com.institucion.business.IRelacionFacade;
import co.com.institucion.business.dto.AsignaturaDTO;
import co.com.institucion.business.dto.ColegioDTO;
import co.com.institucion.business.dto.CursoDTO;
import co.com.institucion.business.dto.EstudianteDTO;
import co.com.institucion.business.dto.HorarioDTO;
import co.com.institucion.business.dto.ProfesorDTO;
import co.com.institucion.business.dto.RelacionDTO;
import co.com.institucion.business.enums.EnumResponseWS;
import co.com.institucion.business.util.Utility;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ECM1378G
 */
@Path("Del")
public class InfoColegioDelServiceImpl implements IInfoColegioDelService {

    @EJB
    private IColegioFacade iColegioFacade;
    @EJB
    private ICursoFacade iCursoFacade;
    @EJB
    private IAsignaturaFacade iAsignaturaFacade;
    @EJB
    private IRelacionFacade iRelacionFacade;
    @EJB
    private IProfesorFacade iProfesorFacade;
    @EJB
    private IEstudianteFacade iEstudianteFacade;
    @EJB
    private IHorarioFacade iHorarioFacade;

    @DELETE
    @Override
    @Path("/deleteColegio/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteColegio(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iColegioFacade.deleteColegio(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    @Path("/deleteCurso/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteCurso(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iCursoFacade.deleteCurso(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    @Path("/deleteAsignatura/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteAsignatura(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iAsignaturaFacade.deleteAsignatura(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    @Path("/deleteRelacion/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteRelacion(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iRelacionFacade.deleteRelacion(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    @Path("/deleteProfesor/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteProfesor(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iProfesorFacade.deleteProfesor(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    @Path("/deleteEstudiante/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteEstudiante(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iEstudianteFacade.deleteEstudiante(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    @Path("/deleteHorario/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response deleteHorario(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            iHorarioFacade.deleteHorario(id);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }
}
