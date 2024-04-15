package org.divier.spring.ms.gateway.request;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigurationMSCompras {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptorMSCompras(
            @Value("${service.security.secure-key-username-ms-compras}") String username,
            @Value("${service.security.secure-key-password-ms-compras}") String password
    ) {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
