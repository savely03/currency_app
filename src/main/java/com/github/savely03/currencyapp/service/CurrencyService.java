package com.github.savely03.currencyapp.service;

import com.github.savely03.currencyapp.dto.CurrencyRatesDto;

import java.time.LocalDate;

public interface CurrencyService {

   CurrencyRatesDto getCurrencyRatesByDate(LocalDate date);

}

