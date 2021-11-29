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
import co.com.institucion.business.util.ValidatorUtil;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("List")
public class InfoColegioListServiceImpl implements IInfoColegioListService {

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

    @GET
    @Override
    @Path("/getColegio/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getColegio(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            ColegioDTO colegioDTO = iColegioFacade.getColegio(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<ColegioDTO>().validateResponse(colegioDTO, ColegioDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getCurso/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getCurso(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            CursoDTO cursoDTO = iCursoFacade.getCurso(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<CursoDTO>().validateResponse(cursoDTO, CursoDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getAsignatura/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getAsignatura(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            AsignaturaDTO asignaturaDTO = iAsignaturaFacade.getAsignatura(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<AsignaturaDTO>().validateResponse(asignaturaDTO, AsignaturaDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getRelacion/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getRelacion(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            RelacionDTO relacionDTO = iRelacionFacade.getRelacion(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<RelacionDTO>().validateResponse(relacionDTO, RelacionDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getProfesor/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getProfesor(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            ProfesorDTO profesorDTO = iProfesorFacade.getProfesor(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<ProfesorDTO>().validateResponse(profesorDTO, ProfesorDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getEstudiante/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getEstudiante(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            EstudianteDTO estudianteDTO = iEstudianteFacade.getEstudiante(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<EstudianteDTO>().validateResponse(estudianteDTO, EstudianteDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getHorario/{id}")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getHorario(@Context HttpHeaders headers, @PathParam("id") Long id) {

        try {
            HorarioDTO horarioDTO = iHorarioFacade.getHorario(id);
            return Response.ok(
                    new Gson().toJson(
                            new ValidatorUtil<HorarioDTO>().validateResponse(horarioDTO, HorarioDTO.class)),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: " + e.getMessage()).build();
        }
    }
}
