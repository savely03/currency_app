package com.github.savely03.currencyapp.constants;

import com.github.savely03.currencyapp.dto.CurrencyDto;
import com.github.savely03.currencyapp.dto.CurrencyRatesDto;

import java.util.Collections;

public class CurrencyConstants {

    public static final CurrencyDto CURRENCY_DTO = CurrencyDto.builder().build();
    public static final CurrencyRatesDto CURRENCY_RATES_DTO  =
            CurrencyRatesDto.builder().valutes(Collections.singletonList(CURRENCY_DTO)).build();

    public static final String ROOT_CB = "https://www.cbr.ru/scripts/XML_daily.asp?date_req={date}";
}
