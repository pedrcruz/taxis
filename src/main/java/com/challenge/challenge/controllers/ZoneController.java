package com.challenge.challenge.controllers;

import com.challenge.challenge.dao.Top5ZoneDTO;
import com.challenge.challenge.dao.ZoneDTO;
import com.challenge.challenge.enums.ZoneOrder;
import com.challenge.challenge.services.ZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Api(tags = "Api of zones management")
@RestController("/api/v1/zones")
@AllArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @ApiOperation(value = "Returns the top 5 zones by chosen method")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", defaultValue = "0", paramType = "query", dataTypeClass = ZoneOrder.class,
                    value = "order"),
    })
    @GetMapping(value = "/top-zones")
    public ResponseEntity<List<Top5ZoneDTO>> getTopZone(@RequestParam ZoneOrder order) {
        return ResponseEntity.ok(zoneService.getTopZone(order));

    }

    @ApiOperation(value = "Returns the zone data on chosen date")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "zoneId", defaultValue = "0", paramType = "query", dataTypeClass = Long.class,
                    value = "Id from zone"),
            @ApiImplicitParam(name = "date", defaultValue = "0", paramType = "query", dataTypeClass = LocalDate.class,
                    value = "data"),
    })
    @GetMapping(value = "/zone-trips")
    public ResponseEntity<ZoneDTO> getZoneTrips(@RequestParam Long zoneId, @RequestParam
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(zoneService.getZoneTrips(zoneId, date));
    }
}
