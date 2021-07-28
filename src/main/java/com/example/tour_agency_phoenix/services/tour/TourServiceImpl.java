package com.example.tour_agency_phoenix.services.tour;

import com.example.tour_agency_phoenix.domain.Tour;
import com.example.tour_agency_phoenix.repositories.TourRepository;
import com.example.tour_agency_phoenix.utils.TransportType;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Service
public class TourServiceImpl implements TourService {
    public final TourRepository tourRepository;

    public TourServiceImpl(final TourRepository repository) {
        this.tourRepository = repository;
    }

    @Override
    public List<Tour> getFeaturedTours() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> findByKeyword(String keyword) {
        return tourRepository.findByKeyword(keyword);
    }

    @Override
    public Tour findById(UUID id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Object with id not found"));
    }


    @Override
    public void createTour(){
        Tour tour = Tour.builder()
                .name("Dubai")
                .duration(4)
                .price(3500)
                .sale(true)
                .salePrice(3000)
                .featured(true)
                .featuredImage("dubai.jpg")
                .image("dubai.jpg")
                .createdAt(LocalDateTime.now())
                .transport(TransportType.PLANE)
                .reservations(7)
                .title("4 Days in Dubai for First Timers Visiting With Family & Friends")
                .subtitle("Price starting from 3000€")
                .description("Dubai offers a full range of activities and attractions for almost any age. ")
                .itinerary("/Dubai")
                .build();
        tourRepository.save(tour);

    }
}
