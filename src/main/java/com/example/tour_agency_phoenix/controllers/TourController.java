package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.domain.Tour;
import com.example.tour_agency_phoenix.services.tour.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/tours")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Tour> get(@PathVariable UUID id){
        var  item = this.tourService.findById(id);
        return item.isPresent() ?ResponseEntity.ok(item.get())
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Tour> getAll(){
        return tourService.findAll();
    }
}
