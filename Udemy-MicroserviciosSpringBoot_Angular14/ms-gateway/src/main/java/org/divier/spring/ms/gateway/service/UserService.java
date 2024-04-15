package org.divier.spring.ms.gateway.service;

import org.divier.spring.ms.gateway.model.Role;
import org.divier.spring.ms.gateway.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUserName(String userName);

    void changeRole(Role role, String userName);

    User findByUsernameReturnToken(String username);
}
