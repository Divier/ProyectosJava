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
import co.com.institucion.business.dto.RelacionDTO;
import co.com.institucion.business.dto.EstudianteDTO;
import co.com.institucion.business.dto.ProfesorDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import co.com.institucion.business.IRelacionFacade;
import co.com.institucion.business.dto.AsignaturaDTO;
import co.com.institucion.business.dto.ColegioDTO;
import co.com.institucion.business.dto.CursoDTO;
import co.com.institucion.business.dto.HorarioDTO;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ECM1378G
 */
@Path("ListAll")
public class InfoColegioListAllServiceImpl implements IInfoColegioListAllService {

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
    @Path("/getColegios")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getColegios(@Context HttpHeaders headers) {

        try {
            List<ColegioDTO> lsColegioDTO = iColegioFacade.getColegios();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsColegioDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getCursos")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getCursos(@Context HttpHeaders headers) {

        try {
            List<CursoDTO> lsCursoDTO = iCursoFacade.getCursos();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsCursoDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getAsignaturas")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getAsignaturas(@Context HttpHeaders headers) {

        try {
            List<AsignaturaDTO> lsAsignaturaDTO = iAsignaturaFacade.getAsignaturas();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsAsignaturaDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getRelaciones")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getRelaciones(@Context HttpHeaders headers) {

        try {
            List<RelacionDTO> lsRelacionDTO = iRelacionFacade.getRelaciones();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsRelacionDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getProfesores")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getProfesores(@Context HttpHeaders headers) {

        try {
            List<ProfesorDTO> lsProfesorDTO = iProfesorFacade.getProfesores();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsProfesorDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }

    @GET
    @Override
    @Path("/getEstudiantes")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getEstudiantes(@Context HttpHeaders headers) {

        try {
            List<EstudianteDTO> lsEstudianteDTO = iEstudianteFacade.getEstudiantes();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsEstudianteDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }
    
    @GET
    @Override
    @Path("/getHorarios")
    @Consumes({"application/json;charset=utf-8"})
    @Produces({"application/json;charset=utf-8"})
    public Response getHorarios(@Context HttpHeaders headers) {

        try {
            List<HorarioDTO> lsHorarioDTO = iHorarioFacade.getHorarios();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(lsHorarioDTO), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error en backend: "+e.getMessage()).build();
        }
    }
}
