package com.example.tour_agency_phoenix.services.user;

import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.repositories.UserRepository;
import com.example.tour_agency_phoenix.services.tour.SaveTourRequest;
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
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
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



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UUID save(User user) {
        var dbItem = userRepository.findById(user.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setFirstName(user.getFirstName());
            dbItem.get().setLastName(user.getLastName());
            dbItem.get().setEmail(user.getEmail());
            dbItem.get().setPassword(user.getPassword());
            dbItem.get().setRole(user.getRole());
            dbItem.get().setBirthDate(user.getBirthDate());
            userRepository.save(dbItem.get());
            return dbItem.get().getId();
        }
        var newItem = User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .birthDate(user.getBirthDate())
                .build();
        userRepository.save(newItem);
        return newItem.getId();
    }

    @Override
    public void delete(UUID id) {
        var item = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        userRepository.delete(item);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
