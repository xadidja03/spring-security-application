package com.example.exam.entity;
import com.example.exam.entity.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

public class AppUserDetails extends AppUser implements UserDetails {

    public AppUserDetails(AppUser appUser){
        super.setUsername(appUser.getUsername());
        super.setActive(appUser.isActive());
        super.setUsername(appUser.getUsername());
        super.setPassword(appUser.getPassword());
        super.setRoles(appUser.getRoles());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
