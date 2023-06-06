package com.example.exam.service;
import com.example.exam.entity.AppUserDetails;
import com.example.exam.entity.model.AppUser;
import com.example.exam.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserDetailService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsernameAndActive(username, true)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found! " + username));
        return new AppUserDetails(appUser);
    }

    public ResponseEntity<String> save(AppUser appUser) {
        Optional<AppUser> byUsername = appUserRepository.findByUsername(appUser.getUsername());
        if (byUsername.isEmpty()){
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            appUserRepository.save(appUser);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("You are welcome " + appUser.getUsername());

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists: " + appUser.getUsername());

        }
    }
 }
