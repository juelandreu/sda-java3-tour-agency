package com.example.tour_agency_phoenix.services.user;

import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.repositories.UserRepository;
import com.example.tour_agency_phoenix.services.user.UserService;
import com.example.tour_agency_phoenix.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public final UserRepository userRepository;

    public UserServiceImpl(final UserRepository repository){
        this.userRepository=repository;
    }

    @Override
    public List<User> getFeaturedUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Object with id not found"));
    }

    @Override
    public void createUser() {
        User user= User.builder()
                .email("aleksiabega123@gmail.com")
                .firstName("Aleksia")
                .lastName("Bega")
                .birthDate(LocalDateTime.of(2001, Month.SEPTEMBER,30,17,30))
                .password("aleksoa01")
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
    }

}
