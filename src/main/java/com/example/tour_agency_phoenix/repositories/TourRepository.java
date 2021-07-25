package com.example.tour_agency_phoenix.repositories;

import com.example.tour_agency_phoenix.domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {
}
