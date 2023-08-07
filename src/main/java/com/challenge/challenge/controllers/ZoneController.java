package com.challenge.challenge.controllers;

import com.challenge.challenge.dao.Top5ZoneDTO;
import com.challenge.challenge.dao.ZoneDTO;
import com.challenge.challenge.enums.ZoneOrder;
import com.challenge.challenge.services.ZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Api of zones management")
@RestController("/api/v1/zones")
@AllArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @Operation(summary = "Returns the top 5 zones by chosen method",
            parameters = {
                    @Parameter(name = "order", in = ParameterIn.QUERY,
                            content = @Content(schema = @Schema(type = "string", allowableValues = { "DROPOFF", "PICKUP" })),
                            description = "order")
            })
    @GetMapping(value = "/top-zones")
    public ResponseEntity<List<Top5ZoneDTO>> getTopZone(@RequestParam ZoneOrder order) {
        return ResponseEntity.ok(zoneService.getTopZone(order));
    }

    @Operation(summary = "Returns the zone data on chosen date",
            parameters = {
                    @Parameter(name = "zoneId", in = ParameterIn.QUERY,
                            content = @Content(schema = @Schema(defaultValue = "0")),
                            description = "Id from zone"),
                    @Parameter(name = "date", in = ParameterIn.QUERY,
                            content = @Content(schema = @Schema(defaultValue = "2023-01-01")),
                            description = "data")
            })
    @GetMapping(value = "/zone-trips")
    public ResponseEntity<ZoneDTO> getZoneTrips(@RequestParam Long zoneId, @RequestParam
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(zoneService.getZoneTrips(zoneId, date));
    }
}
