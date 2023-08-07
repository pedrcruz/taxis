package com.challenge.challenge.mapper;

import com.challenge.challenge.dao.Top5ZoneDTO;
import com.challenge.challenge.dao.TripDTO;
import com.challenge.challenge.dao.ZoneDTO;
import com.challenge.challenge.models.Trip;
import com.challenge.challenge.projections.Top5ZoneProjection;
import com.challenge.challenge.projections.ZoneProjection;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ZoneMapper {

    Top5ZoneDTO map(Top5ZoneProjection top5ZoneProjection);

    ZoneDTO map(ZoneProjection zoneProjection);

    Trip map(TripDTO trip);
}
