package com.example.tour_agency_phoenix.domain;

import com.example.tour_agency_phoenix.utils.Role;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "ta_user")
public class User {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id = UUID.fromString("00000000-0000-0000-0000-000000000000");
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    @Enumerated(value = EnumType.STRING)
    protected Role role;
    protected LocalDateTime birthDate = LocalDateTime.now();




}


