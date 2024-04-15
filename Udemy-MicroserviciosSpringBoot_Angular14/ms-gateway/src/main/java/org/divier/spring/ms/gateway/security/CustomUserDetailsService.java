package org.divier.spring.ms.gateway.security;

import org.divier.spring.ms.gateway.model.User;
import org.divier.spring.ms.gateway.service.UserService;
import org.divier.spring.ms.gateway.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe en el sistema"));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.converToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user)
                .id(user.getId())
                .userName(userName)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
