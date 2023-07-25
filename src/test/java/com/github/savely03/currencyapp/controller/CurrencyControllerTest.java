package com.github.savely03.currencyapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.savely03.currencyapp.dto.CurrencyRatesDto;
import com.github.savely03.currencyapp.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CurrencyControllerTest {

    private final String root = "/currency";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private ObjectMapper objectMapper;
    private final LocalDate date = LocalDate.now();

    @Test
    void getCurrencyTest() throws Exception {
        String strDate = date.toString();
        CurrencyRatesDto expected = currencyService.getCurrencyRatesByDate(date);

        mockMvc.perform(get(root)
                        .param("date", strDate)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.date").value(strDate))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    void getCurrencyWhenIncorrectDateFormatTest() throws Exception {
        mockMvc.perform(get(root)
                        .param("date", date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}