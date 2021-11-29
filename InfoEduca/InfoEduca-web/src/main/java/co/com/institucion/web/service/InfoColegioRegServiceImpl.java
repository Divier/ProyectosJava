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
import javax.ws.rs.POST;
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
@Path("Reg")
public class InfoColegioRegServiceImpl implements IInfoColegioRegService {

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

    @POST
    @Override
    @Path("/saveColegio")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveColegio(@Context HttpHeaders headers, ColegioDTO colegioDTO) {

        try {
            iColegioFacade.createColegio(colegioDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @POST
    @Override
    @Path("/saveCurso")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveCurso(@Context HttpHeaders headers, CursoDTO cursoDTO) {

        try {
            iCursoFacade.createCurso(cursoDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @POST
    @Override
    @Path("/saveAsignatura")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveAsignatura(@Context HttpHeaders headers, AsignaturaDTO asignaturaDTO) {

        try {
            iAsignaturaFacade.createAsignatura(asignaturaDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @POST
    @Override
    @Path("/saveRelacion")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveRelacion(@Context HttpHeaders headers, RelacionDTO relacionDTO) {

        try {
            iRelacionFacade.createRelacion(relacionDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @POST
    @Override
    @Path("/saveProfesor")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveProfesor(@Context HttpHeaders headers, ProfesorDTO profesorDTO) {

        try {
            iProfesorFacade.createProfesor(profesorDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @POST
    @Override
    @Path("/saveEstudiante")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveEstudiante(@Context HttpHeaders headers, EstudianteDTO estudianteDTO) {

        try {
            iEstudianteFacade.createEstudiante(estudianteDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }   

    @POST
    @Override
    @Path("/saveHorario")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response saveHorario(@Context HttpHeaders headers, HorarioDTO horarioDTO) {

        try {
            iHorarioFacade.createHorario(horarioDTO);
            return Response.ok(new Gson().toJson(Utility.generateResponse(EnumResponseWS.SUCCESS)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }
}
