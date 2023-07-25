package com.github.savely03.currencyapp.service.impl;

import com.github.savely03.currencyapp.Exception.BadRequestException;
import com.github.savely03.currencyapp.dto.CurrencyRatesDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.github.savely03.currencyapp.constants.CurrencyConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CurrencyServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    private CurrencyServiceImpl currencyService;

    private final LocalDate date = LocalDate.now();


    @BeforeEach
    void setUp() {
        currencyService = new CurrencyServiceImpl(restTemplate, ROOT_CB);
    }

    @Test
    void getCurrencyRatesByDateTest() {
        when(restTemplate.getForObject(
                ROOT_CB,
                CurrencyRatesDto.class,
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
        ).thenReturn(CURRENCY_RATES_DTO);

        CurrencyRatesDto actual = currencyService.getCurrencyRatesByDate(date);

        assertThat(actual).isEqualTo(CURRENCY_RATES_DTO);
        assertThat(actual.getValutes()).containsOnly(CURRENCY_DTO);
    }

    @Test
    void getCurrencyRatesByDateWhenBadRequestExceptionTest() {
        when(restTemplate.getForObject(
                ROOT_CB,
                CurrencyRatesDto.class,
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
        ).thenReturn(null);

        assertThatExceptionOfType(BadRequestException.class).isThrownBy(
                () -> currencyService.getCurrencyRatesByDate(date)
        );
    }
}