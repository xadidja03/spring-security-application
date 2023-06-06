package com.example.exam.repository;
import com.example.exam.entity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsernameAndActive(String username, boolean active);
    Optional<AppUser> findByUsername(String username);

}
