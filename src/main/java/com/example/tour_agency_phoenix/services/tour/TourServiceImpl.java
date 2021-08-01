package com.example.tour_agency_phoenix.services.tour;

import com.example.tour_agency_phoenix.domain.Tour;
import com.example.tour_agency_phoenix.repositories.TourRepository;
import com.example.tour_agency_phoenix.utils.TransportType;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
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
    public Optional<Tour> findById(UUID id) {
        return tourRepository.findById(id);
    }

    public List<Tour> getTopTours() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> getToursByBus() {
        return tourRepository.tourByBus();
    }

    @Override
    public List<Tour> getToursByPlane() {
        return tourRepository.tourByPlane();
    }

    @Override
    public List<Tour> getToursByCruise() {
        return tourRepository.tourByCruise();
    }

    @Override
    public int save(SaveTourRequest request) {
        return 0;
    }

    @Override
    public List<Tour> findAll() {
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
                .image("spain.jpg")
                .createdAt(LocalDateTime.of(2021,Month.JULY,22,12,00))
                .transport(TransportType.PLANE)
                .reservations(10)
                .title("Traditional 5 Day Spain ")
                .subtitle("Price starting from 800€")
                .description("It’s hard to find a destination with a richer history than Italy. ")
                .itinerary("Day 1\n" +
                        "Welcome to Bilbao - Food & City Tour\n" +
                        "Upon arrival at the airport, a driver will pick you up and transfer you to your hotel in the city center.\n" +
                        "On this walking tour, you'll visit the city's historic Casco Viejo (\"old quarter\").This is a pedestrian area filled with colorful old buildings, cafés, bars, markets, and boutiques.\n" +
                        "Day 2\n" +
                        "Guggenheim Museum Tour\n" +
                        "In the morning, you'll visit the most famous building in Bilbao: the Guggenheim Museum.\n" +
                        "This guided tour focuses much on the architecture of the museum. The building itself is a contemporary masterpiece designed by the legendary Frank Gehry— a glimmering titanium structure that looks like a sculpture.\n" +
                        "Day 3\n" +
                        "Transfer to San Sebastian - Coastal Tour & Wine Tasting\n" +
                        "In the morning you'll leave Bilbao for San Sebastian. While it's only an hour drive from one city to the other, the Basque coast is too stunning to rush.\n" +
                        "Your first stop is the island of Gaztelugatxe.This little island is most noteworthy for the long stone bridge that connects it to the mainland.From Gaztelugatxe, you'll continue driving a few minutes along the coast to the colorful fishing village of Bermeo.\n" +
                        "After the meal, you and your driver will continue east to San Sebastian. Upon arrival, you'll check into your hotel and can spend the remainder of the day at leisure.\n" +
                        "Day 4\n" +
                        "Walking Tour of San Sebastian\n" +
                        "In the morning you'll meet a private guide and enjoy a four-hour tour of San Sebastian. It begins in the famous Old Town, which is situated in the east of San Sebastian.You'll stroll around the neighborhood, stopping at pintxos bars and cafés as you go.\n" +
                        "For great views, you and your guide can take a ferry to the iconic offshore island of Santa Clara, or ride a funicular up to Mont Igualdo, which offers sweeping panoramas. You might also stroll the banks of the Urumea River, where you'll find the 19th-century Victoria Eugenia Theatre, the palatial Maria Cristina Hotel, and many aristocratic houses dating to the turn of the 20th century.\n" +
                        "After the tour, you'll return to your hotel and can spend the remainder of the day however you see fit.\n" +
                        "Day 5\n" +
                        "Depart Spain\n" +
                        "It's time to say farewell to Spain! Depending on the time of your flight or train reservation, squeeze in one more morning of sight-seeing, perhaps picking up some last-minute souvenirs. At the designated time you will be picked up at your hotel and transferred to the airport or rail station for your departure onwards.\n" +
                        "white_tick\n" +
                        "eyes\n" +
                        "raised_hands\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n")
                .build();
        tourRepository.save(tour);
    }
}
