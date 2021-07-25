package com.example.tour_agency_phoenix.repositories;

import com.example.tour_agency_phoenix.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}