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

    public List<Tour> getTopTours() {
        return tourRepository.findAll();
    }

    @Override
    public void createTour(){
        Tour tour = Tour.builder()
                .name("Spain")
                .duration(5)
                .price(800)
                .sale(false)
                .salePrice(800)
                .featured(false)
                .featuredImage("spain.jpg")
                .image("static/img/spain/basque.jpg")
                .createdAt(LocalDateTime.now())
                .transport(TransportType.PLANE)
                .reservations(10)
                .title("The Grand Spain Tour")
                .subtitle("Price starting from 800€")
                .description("A brisk five-day holiday in Spanish Basque Country could be just what the doctor ordered.")
                .itinerary("/Spain")
                .build();
        tourRepository.save(tour);

    }
}
