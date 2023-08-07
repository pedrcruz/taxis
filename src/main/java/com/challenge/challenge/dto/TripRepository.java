package com.challenge.challenge.dto;

import com.challenge.challenge.enums.TripType;
import com.challenge.challenge.models.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {
    Page<Trip> findAllByType(TripType type,
             Pageable pageable);
}
