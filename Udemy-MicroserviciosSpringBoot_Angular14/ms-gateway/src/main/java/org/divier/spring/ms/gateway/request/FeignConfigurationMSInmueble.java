package org.divier.spring.ms.gateway.request;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigurationMSInmueble {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptorMSInmueble(
            @Value("${service.security.secure-key-username-ms-inmueble}") String username,
            @Value("${service.security.secure-key-password-ms-inmueble}") String password
    ) {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
