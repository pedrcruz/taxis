package com.challenge.challenge.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ZoneDTO {
    String zone;
    LocalDate date;
    Integer pickupTotal;
    Integer dropoffTotal;
}
