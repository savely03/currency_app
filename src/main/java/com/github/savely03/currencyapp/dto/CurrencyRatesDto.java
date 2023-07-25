package com.github.savely03.currencyapp.dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@ToString
public class CurrencyRatesDto {

    @XmlElement(name = "Date")
    private String date;

    @XmlElement(name = "Valute")
    private List<CurrencyDto> valutes;
}
