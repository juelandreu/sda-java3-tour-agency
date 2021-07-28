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
                .name("Italy")
                .duration(7)
                .price(1000)
                .sale(false)
                .salePrice(1000)
                .featured(false)
                .image("italy.jpg")
                .createdAt(LocalDateTime.of(2021,Month.JULY,22,12,00))
                .transport(TransportType.CRUISE)
                .reservations(9)
                .featuredImage("italy.jpg")
                .title("Traditional 7 Day Italy Itinerary")
                .subtitle("Price starting from 1000€")
                .description("It’s hard to find a destination with a richer history than Italy. ")
                .itinerary("/italy")
                .build();
        tourRepository.save(tour);

    }
}
