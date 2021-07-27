package com.example.tour_agency_phoenix.repositories;

import com.example.tour_agency_phoenix.domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {
    @Query(value = "SELECT t FROM Tour t where t.featured = 1")
     List<Tour> getFeaturedTours();


    @Query(value = "SELECT t FROM Tour t where t.name like %:keyword%")
     List<Tour> findByKeyword(@Param("keyword") String keyword);
}
