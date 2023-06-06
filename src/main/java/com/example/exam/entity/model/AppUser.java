package com.example.exam.entity.model;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
//@Accessors(chain = true,fluent = true)

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    @Builder.Default
    boolean active=true;
    @ManyToMany(mappedBy = "appUsers")
    List<Role> roles;

}
