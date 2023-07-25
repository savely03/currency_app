package com.github.savely03.currencyapp.service.impl;

import com.github.savely03.currencyapp.Exception.BadRequestException;
import com.github.savely03.currencyapp.Exception.IncorrectDateFormatException;
import com.github.savely03.currencyapp.dto.CurrencyRatesDto;
import com.github.savely03.currencyapp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.github.savely03.currencyapp.constants.Regex.DATE;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;

    @Value("${currencies.url.by.date}")
    private String root;

    @Override
    public CurrencyRatesDto getCurrencyRatesByDate(LocalDate date) {
        if (!date.toString().matches(DATE)) {
            throw new IncorrectDateFormatException();
        }
        date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Optional.ofNullable(
                restTemplate.getForObject(
                        root,
                        CurrencyRatesDto.class, date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                )).orElseThrow(BadRequestException::new);
    }

}
