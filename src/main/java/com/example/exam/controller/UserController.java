package com.example.exam.controller;
import com.example.exam.entity.model.AppUser;
import com.example.exam.service.AppUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
    private final AppUserDetailService appUserDetailService;
    @PostMapping("/")
    public ResponseEntity<String> home(@RequestBody AppUser appUser){
        return appUserDetailService.save(appUser);
    }
    @GetMapping("user")
    public  String user(){
        return "Hello Spring Security from user!";
    }

    @GetMapping("admin")
    public  String admin(){
        return "Hello Spring Security from admin!";
    }
}
