package com.challenge.challenge.controllers;

import com.challenge.challenge.dao.TripDTO;
import com.challenge.challenge.enums.TripType;
import com.challenge.challenge.services.TripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Api of travel management")
@RestController("/api/v1/trips")
@AllArgsConstructor
public class TripController {

    private final TripService tripService;

    @ApiOperation(value = "Returns a pageable list of yellow trips")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "0", paramType = "query",
                    value = "Page number (0..N)."),
            @ApiImplicitParam(name = "size", defaultValue = "10", paramType = "query", dataTypeClass = Integer.class,
                    value = "data per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, paramType = "query", dataTypeClass = String.class,
                    value = "Ordering criteria in the format: field(,asc|desc). " +
                            "default sort - ascending. " +
                            "Multiple sorting criteria are allowed.")
    })
    @GetMapping(value = "/list-yellow")
    public ResponseEntity<Page<TripDTO>> getYellowTrips(@PageableDefault(sort = {
            "id"}, direction = Sort.Direction.ASC, size = 20) Pageable pageable) {
        Page<TripDTO> tripDTOPage = tripService.getTrips(TripType.YELLOW, pageable);
        return ResponseEntity.ok(tripDTOPage);
    }
}