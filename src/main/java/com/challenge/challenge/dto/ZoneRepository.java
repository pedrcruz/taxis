package com.challenge.challenge.dto;

import com.challenge.challenge.dao.Top5ZoneDTO;
import com.challenge.challenge.dao.ZoneDTO;
import com.challenge.challenge.models.Zone;
import com.challenge.challenge.projections.Top5ZoneProjection;
import com.challenge.challenge.projections.ZoneProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ZoneRepository extends PagingAndSortingRepository<Zone, Long> {

    @Query(value = "SELECT c.name as zone, " +
            "Count(u.pickup_zone_id) AS pickupTotal, " +
            "SUM(CASE WHEN c.id = " +
            "u.dropoff_zone_id " +
            " THEN 1 END) " +
            "AS dropoffTotal " +
            "FROM zone c " +
            "INNER JOIN trip u ON c.id = u.pickup_zone_id " +
            "GROUP BY c.name " +
            "ORDER BY pickupTotal desc " +
            "LIMIT 5;",
            nativeQuery = true)
    List<Top5ZoneProjection> getTop5ZoneByPickUps();

    @Query(value = "SELECT c.name as zone, " +
            "Count(u.dropoff_zone_id) AS dropoffTotal, " +
            "SUM(CASE WHEN c.id = " +
            "u.pickup_zone_id " +
            "THEN 1 END) " +
            "AS pickupTotal " +
            " FROM zone c " +
            "INNER JOIN trip u ON c.id = u.dropoff_zone_id " +
            "GROUP BY c.name " +
            "ORDER BY dropoffTotal desc " +
            "LIMIT 5;",
            nativeQuery = true)
    List<Top5ZoneProjection> getTop5ZoneByDropOffs();

    @Query(value = "SELECT c.name as zone, \n" +
            "\t   SUM(CASE WHEN c.id = \n" +
            "\t\t   u.pickup_zone_id \n" +
            "\t\t   THEN 1 END) \n" +
            "\t\t   AS pickupTotal,\n" +
            "\t   SUM(CASE WHEN c.id = \n" +
            "\t\t   u.dropoff_zone_id \n" +
            "\t\t   THEN 1 END) \n" +
            "\t\t   AS dropoffTotal\n" +
            " FROM zone c\n" +
            "      INNER JOIN trip u ON c.id = u.pickup_zone_id\n" +
            "WHERE c.id = ?1 AND (DATE(u.pickup_datetime) = ?2 OR DATE(u.pickup_datetime) = ?2)\n" +
            "GROUP BY c.name;\n", nativeQuery = true)
    ZoneProjection getSumPickupsDropOffs(Long zone, LocalDate date);

}
