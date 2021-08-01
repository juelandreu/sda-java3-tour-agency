package com.example.tour_agency_phoenix.services.user;

import com.example.tour_agency_phoenix.domain.User;

import com.example.tour_agency_phoenix.services.tour.SaveTourRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> getFeaturedUsers();
    Optional<User> findById(UUID id);
    void createUser();
   List<User> findAll();
   UUID save(User user);
    void delete(UUID id);
    Optional<User> findByEmail(String email);

}
