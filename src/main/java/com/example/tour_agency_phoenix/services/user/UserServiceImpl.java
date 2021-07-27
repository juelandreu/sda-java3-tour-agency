package com.example.tour_agency_phoenix.services.user;

import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.repositories.UserRepository;
import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public UserServiceImpl(final UserRepository repository){
        this.userRepository=repository;
    }

    @Override
    public List<User> getFeaturedUsers() {
        return userRepository.findAll();
    }

}
