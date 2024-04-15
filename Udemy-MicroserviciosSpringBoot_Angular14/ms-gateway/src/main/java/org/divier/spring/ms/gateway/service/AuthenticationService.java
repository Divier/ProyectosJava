package org.divier.spring.ms.gateway.service;

import org.divier.spring.ms.gateway.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
