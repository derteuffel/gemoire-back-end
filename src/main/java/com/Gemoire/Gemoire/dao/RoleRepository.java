package com.Gemoire.Gemoire.dao;

import com.Gemoire.Gemoire.entity.Role;
import com.Gemoire.Gemoire.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
