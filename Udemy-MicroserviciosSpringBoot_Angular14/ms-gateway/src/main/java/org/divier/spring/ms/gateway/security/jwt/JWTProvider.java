package org.divier.spring.ms.gateway.security.jwt;

import org.divier.spring.ms.gateway.model.User;
import org.divier.spring.ms.gateway.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JWTProvider {
    String generateToken(UserPrincipal principal);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
