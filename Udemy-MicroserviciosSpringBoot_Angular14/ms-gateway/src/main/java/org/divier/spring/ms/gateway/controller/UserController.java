package org.divier.spring.ms.gateway.controller;

import org.divier.spring.ms.gateway.model.Role;
import org.divier.spring.ms.gateway.security.UserPrincipal;
import org.divier.spring.ms.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal principal, @PathVariable Role role) {

        userService.changeRole(role, principal.getUsername());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {

        return new ResponseEntity<>(userService.findByUsernameReturnToken(userPrincipal.getUsername()), HttpStatus.OK);
    }

    @PostMapping("/me")
    public void getUserProfile(@AuthenticationPrincipal UserDetails user ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("principal : " + user);
        System.out.println("principal : " + authentication.getPrincipal());
        System.out.println("Implementing class of UserDetails: " + authentication.getPrincipal().getClass());
        System.out.println("Implementing class of UserDetailsService: " + userService.getClass());
    }
}
