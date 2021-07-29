package com.example.tour_agency_phoenix;

import com.example.tour_agency_phoenix.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class TourAgencyPhoenixApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourAgencyPhoenixApplication.class, args);
    }

}
