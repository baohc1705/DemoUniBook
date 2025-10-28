package com.unibook.IdentityService.repository;

import com.unibook.IdentityService.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // select * from role
}
