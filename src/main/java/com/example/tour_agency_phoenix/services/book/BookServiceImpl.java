package com.example.tour_agency_phoenix.services.book;

import com.example.tour_agency_phoenix.domain.Book;
import com.example.tour_agency_phoenix.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository repository){
        this.bookRepository=repository;
    }

    @Override
    public List<Book> getFeaturedBookings() {
        return bookRepository.findAll();
    }
}
