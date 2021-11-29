/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ECM1378G
 */
@Getter
@Setter
public class ProfesorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idPrf;
    private String nombre;
    private BigDecimal salario;
}
