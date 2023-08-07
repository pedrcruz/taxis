package com.challenge.challenge.controllers;

import com.challenge.challenge.dao.TripDTO;
import com.challenge.challenge.enums.TripType;
import com.challenge.challenge.services.TripService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.Explode;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Api of travel management")
@RestController("/api/v1/trips")
@AllArgsConstructor
public class TripController {

    private final TripService tripService;

    @Operation(summary = "Returns a pageable list of yellow trips",
            parameters = {
                    @Parameter(name = "page", in = ParameterIn.QUERY,
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "0")),
                            description = "Page number (0..N)."),
                    @Parameter(name = "size", in = ParameterIn.QUERY,
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "10")),
                            description = "data per page."),
                    @Parameter(name = "sort", in = ParameterIn.QUERY,
                            content = @Content(array = @ArraySchema(schema = @Schema(type = "string", defaultValue = "asc"))),
                            description = "Ordering criteria in the format: field(,asc|desc). " +
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