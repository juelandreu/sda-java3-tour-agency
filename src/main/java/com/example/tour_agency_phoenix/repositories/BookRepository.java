package com.example.tour_agency_phoenix.repositories;

import com.example.tour_agency_phoenix.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
