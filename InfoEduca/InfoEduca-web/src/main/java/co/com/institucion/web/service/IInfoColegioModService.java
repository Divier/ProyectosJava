/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.web.service;

import co.com.institucion.business.dto.AsignaturaDTO;
import co.com.institucion.business.dto.ColegioDTO;
import co.com.institucion.business.dto.CursoDTO;
import co.com.institucion.business.dto.EstudianteDTO;
import co.com.institucion.business.dto.HorarioDTO;
import co.com.institucion.business.dto.ProfesorDTO;
import co.com.institucion.business.dto.RelacionDTO;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author ECM1378G
 */
public interface IInfoColegioModService {

    public Response updateColegio(HttpHeaders headers, ColegioDTO colegioDTO);

    public Response updateCurso(HttpHeaders headers, CursoDTO cursoDTO);

    public Response updateAsignatura(HttpHeaders headers, AsignaturaDTO asignaturaDTO);

    public Response updateRelacion(HttpHeaders headers, RelacionDTO relacionDTO);

    public Response updateProfesor(HttpHeaders headers, ProfesorDTO profesorDTO);

    public Response updateEstudiante(HttpHeaders headers, EstudianteDTO estudianteDTO);

    public Response updateHorario(HttpHeaders headers, HorarioDTO horarioDTO);
}
