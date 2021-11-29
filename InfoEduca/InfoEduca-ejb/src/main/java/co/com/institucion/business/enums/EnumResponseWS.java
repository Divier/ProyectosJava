/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.enums;

import lombok.Getter;

/**
 *
 * @author ECM1378G
 */
@Getter
public enum EnumResponseWS {
    
    SUCCESS(0, "Operacion exitosa", "succes"),
    ERROR(-1, "Error en operacion", "error");
    
    private Integer code;
    private String message;
    private String status;
    
    private EnumResponseWS(Integer code, String message, String status) {
        
        this.code = code;
        this.message = message;
        this.status = status;
    }   
}
