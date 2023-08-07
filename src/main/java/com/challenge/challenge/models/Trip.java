package com.challenge.challenge.models;


import com.challenge.challenge.enums.TripType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDateTime pickupDatetime;
    LocalDateTime dropoffDatetime;

    TripType type;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "trip_pickup_zone_fkey"), name = "pickup_zone_id")
    private Zone pickupZone;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "trip_dropoff_zone_fkey"), name = "dropoff_zone_id")
    private Zone dropffZone;
}
