package org.divier.spring.ms.gateway.service;

import org.divier.spring.ms.gateway.model.Role;
import org.divier.spring.ms.gateway.model.User;
import org.divier.spring.ms.gateway.repository.UserRepository;
import org.divier.spring.ms.gateway.security.jwt.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTProvider jwtProvider;

    @Override
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        User userCreated = userRepository.save(user);
        userCreated.setToken(jwtProvider.generateToken(userCreated));
        return userCreated;
    }

    @Override
    public Optional<User> findByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void changeRole(Role role, String userName) {

        userRepository.updateUserRole(userName, role);
    }

    @Override
    public User findByUsernameReturnToken(String username) {

        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe:" + username));

        String jwt = jwtProvider.generateToken(user);
        user.setToken(jwt);
        return user;
    }
}
