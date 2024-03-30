package com.example.test_2.repositories;

import com.example.test_2.dtos.QuoteDto;
import com.example.test_2.entities.Quote;
import com.example.test_2.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long>{
    Optional<Quote> findQuoteById(Long id);
    Optional<Quote> updateQuoteById(Long id);
    Optional<Quote> readQuoteById(Long id);
    Optional<Quote> deleteQuoteById(Long id);
    Optional<Quote> findByUsername(String username);
    Optional<Quote> findByAuthor(String author);
}
