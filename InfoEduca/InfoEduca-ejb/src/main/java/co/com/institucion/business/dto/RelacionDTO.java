/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ECM1378G
 */
@Getter
@Setter
public class RelacionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idRel;
    private AsignaturaDTO asignatura;
    private ProfesorDTO profesor;
    private CursoDTO curso;
    private transient List<EstudianteDTO> estudiantes;
}
