package com.github.savely03.currencyapp.service.impl;

import com.github.savely03.currencyapp.Exception.BadRequestException;
import com.github.savely03.currencyapp.dto.CurrencyRatesDto;
import com.github.savely03.currencyapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;

    private final String root;

    public CurrencyServiceImpl(RestTemplate restTemplate, @Value("${currencies.url.cb.by.date}") String root) {
        this.restTemplate = restTemplate;
        this.root = root;
    }

    @Override
    public CurrencyRatesDto getCurrencyRatesByDate(LocalDate date) {
        Optional<CurrencyRatesDto> optionalOfCurrencies = Optional.ofNullable(
                restTemplate.getForObject(
                        root,
                        CurrencyRatesDto.class, date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                )
        );
        CurrencyRatesDto currencies = optionalOfCurrencies.orElseThrow(BadRequestException::new);
        currencies.setDate(date);
        return currencies;
    }

}
