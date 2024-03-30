package com.example.test_2.controllers;

import com.example.test_2.dtos.PublicationQuoteDto;
import com.example.test_2.dtos.QuoteDto;
import com.example.test_2.entities.Quote;
import com.example.test_2.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

    @PostMapping("/publicPhrase")
    public ResponseEntity<?> publicPhrase(@RequestBody PublicationQuoteDto pQuoteDto) {
        Quote quote = quoteService.createNewPhrase(pQuoteDto);
        return ResponseEntity.ok(new QuoteDto(quote.getId(), quote.getUsername(), quote.getAuthor(), quote.getText(), quote.getTimeInsert()));
    }
}
