/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ECM1378G
 */
@Getter
@Setter
public class CursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idCur;
    private Short grado;
    private String salon;
    private ColegioDTO colegio;
}
