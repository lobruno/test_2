package com.example.test_2.service;

import com.example.test_2.dtos.PublicationQuoteDto;
import com.example.test_2.dtos.QuoteDto;
import com.example.test_2.entities.Quote;
import com.example.test_2.repositories.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuoteService {
    private QuoteRepository quoteRepository;


    @Autowired
    public void setQuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }


    public Quote createNewPhrase(PublicationQuoteDto publicationQuoteDto) {
        Quote quote = new Quote();
        quote.setAuthor(publicationQuoteDto.getAuthor());
        quote.setUsername(publicationQuoteDto.getUsername());
        quote.setText(publicationQuoteDto.getText());
        quote.setTimeInsert(publicationQuoteDto.getTimeInsert());
        return quoteRepository.save(quote);
    }

    public Quote updatePhrase(Quote quoteInfo)throws UsernameNotFoundException
    {
        Quote quote = quoteRepository.findQuoteById(quoteInfo.getId()).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Цитата '%s' не найдена", quoteInfo.getId())
        ));
        quoteRepository.updateQuoteById(quoteInfo.getId());

        return  quote;
    }


}
