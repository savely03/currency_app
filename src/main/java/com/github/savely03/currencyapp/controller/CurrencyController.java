package com.github.savely03.currencyapp.controller;

import com.github.savely03.currencyapp.dto.CurrencyRatesDto;
import com.github.savely03.currencyapp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public CurrencyRatesDto getCurrency(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return currencyService.getCurrencyRatesByDate(date);
    }

}
