package com.example.tour_agency_phoenix.services.user;

import com.example.tour_agency_phoenix.domain.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getFeaturedUsers();
    User findById(UUID id);
    void createUser();
}
