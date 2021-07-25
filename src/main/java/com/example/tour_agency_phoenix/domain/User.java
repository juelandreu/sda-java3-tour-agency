package com.example.tour_agency_phoenix.domain;

import com.example.tour_agency_phoenix.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ta_user")
public class User {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    @Enumerated(value = EnumType.STRING)
    protected Role role;
    protected LocalDateTime birthDate;
}
