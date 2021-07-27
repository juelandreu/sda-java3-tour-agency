package com.example.tour_agency_phoenix.services.tour;

import com.example.tour_agency_phoenix.domain.Tour;
import com.example.tour_agency_phoenix.repositories.TourRepository;
import com.example.tour_agency_phoenix.utils.TransportType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

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
    public void createTour(){
        Tour tour = Tour.builder()
                .name("North Albania")
                .duration(5)
                .price(500)
                .sale(true)
                .salePrice(255)
                .saleStartAt(LocalDateTime.now())
                .saleEndAt(LocalDateTime.of(2021, Month.SEPTEMBER,25,12,00))
                .featured(true)
                .featuredImage("Koman-Lake.jpg")
                .image("Koman-Lake.jpg")
                .createdAt(LocalDateTime.now())
                .transport(TransportType.BUS)
                .reservations(5)
                .build();
        tourRepository.save(tour);

    }
}
