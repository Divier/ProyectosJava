/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.util;

import co.com.institucion.business.dto.ResponseDTO;
import co.com.institucion.business.enums.EnumResponseWS;

/**
 *
 * @author ECM1378G
 */
public class Utility {
    
    public synchronized static ResponseDTO generateResponse(EnumResponseWS enumResponseWS) {
        
        ResponseDTO response = new ResponseDTO();
        response.setCode(enumResponseWS.getCode());
        response.setMessage(enumResponseWS.getMessage());
        response.setStatus(enumResponseWS.getStatus());
        return response;
    }
}
