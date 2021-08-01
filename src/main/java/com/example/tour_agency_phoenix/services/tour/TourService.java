package com.example.tour_agency_phoenix.services.tour;

import com.example.tour_agency_phoenix.domain.Tour;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TourService {
     void createTour();
     List<Tour> getFeaturedTours();
     List<Tour> findByKeyword(String keyword);
     Optional<Tour> findById(UUID id);
     List<Tour> getTopTours();
     List<Tour> getToursByBus();
     List<Tour> getToursByPlane();
     List<Tour> getToursByCruise();

     int save(SaveTourRequest request);

     List<Tour> findAll();
}
