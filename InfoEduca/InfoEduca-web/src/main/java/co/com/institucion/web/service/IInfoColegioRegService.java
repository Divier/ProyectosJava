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
public interface IInfoColegioRegService {

    public Response saveColegio(HttpHeaders headers, ColegioDTO colegioDTO);

    public Response saveCurso(HttpHeaders headers, CursoDTO cursoDTO);

    public Response saveAsignatura(HttpHeaders headers, AsignaturaDTO asignaturaDTO);

    public Response saveRelacion(HttpHeaders headers, RelacionDTO relacionDTO);

    public Response saveProfesor(HttpHeaders headers, ProfesorDTO profesorDTO);

    public Response saveEstudiante(HttpHeaders headers, EstudianteDTO estudianteDTO);

    public Response saveHorario(HttpHeaders headers, HorarioDTO horarioDTO);
}
