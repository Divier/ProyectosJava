package org.divier.spring.ms.gateway.repository;

import org.divier.spring.ms.gateway.model.Role;
import org.divier.spring.ms.gateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

    @Modifying
    @Query("update User set role=:role where userName=:userName")
    void updateUserRole(@Param("userName") String userName, @Param("role") Role role);
}
