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
                .name("South Albania")
                .duration(5)
                .price(500)
                .sale(true)
                .salePrice(300)
                .featured(false)
                .image("static/img/south/south1.jpg")
                .createdAt(LocalDateTime.now())
                .transport(TransportType.BUS)
                .reservations(5)
                .title("5 Days Albanian Exotics Riviera and Gjirokstra")
                .subtitle("Tour Price Starting From 300€")
                .description("With its jumble of rugged mountains fringed by pristine curls of beach, Albania's south is the most appealing part of the country.")
                .itinerary("southalbania.html")
                .build();
        tourRepository.save(tour);

    }
}
