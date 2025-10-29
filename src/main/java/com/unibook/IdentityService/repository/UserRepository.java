package com.unibook.IdentityService.repository;

import com.unibook.IdentityService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.isEnabled = TRUE AND u.isLocked = FALSE ")
    List<User> findAllActiveUser();

    @Query("SELECT u FROM User u JOIN Role r WHERE r.name = :roleName ")
    List<User> findByRoleName(@Param("roleName") String roleName);

    @Query("SELECT u FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))  " +
            "OR LOWER(u.fullName) LIKE LOWER(CONCAT('%', :keyword,'%')) ")
    List<User> searchUsers(@Param("keyword") String keyword);
}
