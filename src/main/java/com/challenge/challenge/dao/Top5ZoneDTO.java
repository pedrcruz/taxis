package com.challenge.challenge.dao;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Top5ZoneDTO {
    String zone;
    Long pickupTotal;
    Long dropoffTotal;
}
