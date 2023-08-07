package com.challenge.challenge.services;

import com.challenge.challenge.dao.TripDTO;
import com.challenge.challenge.dto.TripRepository;
import com.challenge.challenge.enums.TripType;
import com.challenge.challenge.mapper.TripMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public Page<TripDTO> getTrips(TripType type, Pageable pageable) {
        return tripRepository.findAllByType(type, pageable)
                .map(tripMapper::map);
    }
}
