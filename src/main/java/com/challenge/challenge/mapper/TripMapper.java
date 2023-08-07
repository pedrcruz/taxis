package com.challenge.challenge.mapper;

import com.challenge.challenge.dao.TripDTO;
import com.challenge.challenge.models.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TripMapper {

    TripDTO map(Trip trip);
    Trip map(TripDTO trip);
}
