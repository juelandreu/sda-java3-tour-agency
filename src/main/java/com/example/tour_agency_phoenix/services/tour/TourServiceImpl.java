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
                .name("Aegean Islands")
                .duration(10)
                .price(1200)
                .sale(false)
                .salePrice(1200)
                .featured(true)
                .image("agean.jpg")
                .createdAt(LocalDateTime.of(2021,Month.JUNE,27,12,00))
                .transport(TransportType.PLANE)
                .reservations(8)
                .featuredImage("agean.jpg")
                .title("A dreamy 10 day tour to the picturesque Greek islands  ")
                .subtitle("Price starting from 1200€")
                .description("The stunningly picturesque Greek islands have inspired mankind back to the time of Homer.")
                .itinerary("/ageanislands")
                .build();
        tourRepository.save(tour);

    }
}
