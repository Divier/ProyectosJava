package org.divier.spring.ms.gateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value="ms-inmueble",
        path="/api/inmueble",
        //url="${inmueble.service.url}",
        configuration = FeignConfigurationMSInmueble.class
)
public interface InmuebleServiceRequest {

    @PostMapping
    Object saveInmueble(@RequestBody Object requestBody);

    @DeleteMapping("{inmuebleId}")
    void deleteInmueble(@PathVariable("inmuebleId") Long inmuebleId);

    @GetMapping()
    List<Object> getAllInmuebles();
}
