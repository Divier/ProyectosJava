/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.web.service.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ECM1378G
 */
@Getter
@Setter
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String status;
    private String message;
    private Integer code;
}
