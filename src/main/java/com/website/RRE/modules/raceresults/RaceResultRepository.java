package com.website.RRE.modules.raceresults;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// repository layer

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
   // Find by best time
   @Query("SELECT r.raceResultID AS raceResultID, r.raceResultRank AS raceResultRank, " +
           "r.raceResultBestTime AS raceResultBestTime, r.raceResultCarNo AS raceResultCarNo, " +
           "r.raceResultEvent AS raceResultEvent, r.raceResultEventActivity AS raceResultEventActivity, " +
           "r.driverID AS driverID, r.garageID AS garageID, " +
           "d.driverName AS driverName, d.driverCarMake AS driverCarMake, " +
           "g.garageName AS garageName, g.garageSpeciality AS garageSpeciality " +
           "FROM RaceResult r " +
           "JOIN Driver d ON r.driverID = d.id " +
           "JOIN Garage g ON r.garageID = g.id " +
           "WHERE r.raceResultBestTime = :raceResultBestTime")
   Optional<Map<String, Object>> findByRaceResultBestTime(@Param("raceResultBestTime") int raceResultBestTime);

    // Find by car number
    List<RaceResult> findByRaceResultCarNo(@Param("raceResultCarNo") int raceResultCarNo);


    // Find by rank
    List<RaceResult> findByRaceResultRank(@Param("raceResultRank") int raceResultRank);


    // Find by event
    List<RaceResult> findByRaceResultEvent(@Param("raceResultEvent") String raceResultEvent);


    // Find by event activity
    List<RaceResult> findByRaceResultEventActivity(@Param("raceResultEventActivity") String raceResultEventActivity);




}

