package com.challenge.challenge.services;

import com.challenge.challenge.dao.Top5ZoneDTO;
import com.challenge.challenge.dao.ZoneDTO;
import com.challenge.challenge.dto.ZoneRepository;
import com.challenge.challenge.enums.ZoneOrder;
import com.challenge.challenge.exceptions.ChallengeException;
import com.challenge.challenge.mapper.ZoneMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;
    private final ZoneMapper zoneMapper;

    public List<Top5ZoneDTO> getTopZone(ZoneOrder zoneOrder) {
        if (zoneOrder.equals(ZoneOrder.DROPOFF)) {
            return zoneRepository.getTop5ZoneByDropOffs().stream().map(zoneMapper::map).collect(Collectors.toList());
        } else if (zoneOrder.equals(ZoneOrder.PICKUP)) {
            return zoneRepository.getTop5ZoneByPickUps().stream().map(zoneMapper::map).collect(Collectors.toList());
        } else {
            throw new ChallengeException("Zone order invalid.");
        }
    }

    public ZoneDTO getZoneTrips(Long zone, LocalDate localDate) {
        var zoneDTO = zoneMapper.map(zoneRepository.getSumPickupsDropOffs(zone, localDate));
        if(zoneDTO != null) {
            zoneDTO.setDate(localDate);
        }
        return zoneDTO;
    }
}
