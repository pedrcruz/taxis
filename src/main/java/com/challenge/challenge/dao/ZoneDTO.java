package com.challenge.challenge.dao;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ZoneDTO {
    String zone;
    LocalDate date;
    Integer pickupTotal;
    Integer dropoffTotal;
}
