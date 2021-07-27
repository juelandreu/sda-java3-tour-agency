package com.example.tour_agency_phoenix.services.tour;

import com.example.tour_agency_phoenix.domain.Tour;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourService {
     void createTour();
     List<Tour> getFeaturedTours();
     List<Tour> findByKeyword(String keyword);
}
