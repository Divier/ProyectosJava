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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ECM1378G
 */
@Path("Mod")
public class InfoColegioModServiceImpl implements IInfoColegioModService {

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

    @PUT
    @Override
    @Path("/updateColegio")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateColegio(@Context HttpHeaders headers, ColegioDTO colegioDTO) {

        try {
            iColegioFacade.updateColegio(colegioDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @PUT
    @Override
    @Path("/updateCurso")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateCurso(@Context HttpHeaders headers, CursoDTO cursoDTO) {

        try {
            iCursoFacade.updateCurso(cursoDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @PUT
    @Override
    @Path("/updateAsignatura")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateAsignatura(@Context HttpHeaders headers, AsignaturaDTO asignaturaDTO) {

        try {
            iAsignaturaFacade.updateAsignatura(asignaturaDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @PUT
    @Override
    @Path("/updateRelacion")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateRelacion(@Context HttpHeaders headers, RelacionDTO relacionDTO) {

        try {
            iRelacionFacade.updateRelacion(relacionDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @PUT
    @Override
    @Path("/updateProfesor")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateProfesor(@Context HttpHeaders headers, ProfesorDTO profesorDTO) {

        try {
            iProfesorFacade.updateProfesor(profesorDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @PUT
    @Override
    @Path("/updateEstudiante")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateEstudiante(@Context HttpHeaders headers, EstudianteDTO estudianteDTO) {

        try {
            iEstudianteFacade.updateEstudiante(estudianteDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @PUT
    @Override
    @Path("/updateHorario")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response updateHorario(@Context HttpHeaders headers, HorarioDTO horarioDTO) {

        try {
            iHorarioFacade.updateHorario(horarioDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }
}
