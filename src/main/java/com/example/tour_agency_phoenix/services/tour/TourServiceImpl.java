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
                .name("North Albania")
                .duration(5)
                .price(500)
                .sale(true)
                .salePrice(255)
                .featured(true)
                .image("static/img/north/Koman-Lake.jpg")
                .createdAt(LocalDateTime.of(2021,Month.JULY,27,12,00))
                .transport(TransportType.BUS)
                .reservations(7)
                .featuredImage("static/img/north/Koman-Lake.jpg")
                .saleStartAt(LocalDateTime.now())
                .saleEndAt(LocalDateTime.of(2021,Month.SEPTEMBER,24,12,00))
                .title("5 Days Tour to Northern Albania ")
                .subtitle("Price starting from 255€")
                .description("Explore mountainous terrain and small villages on this through the remote regions of northern Albania and see the ancient Rozafa Castle, then continue through the Albanian Alps to the scenic Rugova Valley,then take the ferry across Lake Koman.")
                .itinerary("/northalbania")
                .build();
        tourRepository.save(tour);

    }
}
