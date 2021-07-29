package com.example.tour_agency_phoenix.services.user;

import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.repositories.UserRepository;
import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        user.orElseThrow(()->new UsernameNotFoundException("Email Not Found"+ email));

        return user.map(MyUserDetals::new).get();
    }
}
