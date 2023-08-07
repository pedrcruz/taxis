package com.challenge.challenge.dao;

import com.challenge.challenge.models.Zone;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TripDTO {

    LocalDateTime pickupDatetime;
    LocalDateTime dropoffDatetime;
    Zone pickupZone;
    Zone dropoffZone;
}
