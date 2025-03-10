package com.website.RRE.modules.raceresults.repositories;

import com.website.RRE.modules.raceresults.entities.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// repository layer

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
   // Find all race results
   @Query("SELECT r.raceResultID AS raceResultID, r.raceResultRank AS raceResultRank, " +
           "r.raceResultBestTime AS raceResultBestTime, r.raceResultCarNo AS raceResultCarNo, " +
           "r.raceResultEvent AS raceResultEvent, r.raceResultEventActivity AS raceResultEventActivity, " +
           "r.raceResultYear AS raceResultYear, " +
           "r.driverID AS driverID, r.garageID AS garageID, " +
           "d.driverName AS driverName, d.driverCarMake AS driverCarMake, " +
           "g.garageName AS garageName, g.garageSpeciality AS garageSpeciality " +
           "FROM RaceResult r " +
           "JOIN Driver d ON r.driverID = d.id " +
           "JOIN Garage g ON r.garageID = g.id")
   List<Map<String, Object>> findAllRaceResults();

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
   List<Map<String, Object>> findByRaceResultBestTime(@Param("raceResultBestTime") double raceResultBestTime);

    // Find by car number
    List<RaceResult> findByRaceResultCarNo(@Param("raceResultCarNo") int raceResultCarNo);


    // Find by rank
    @Query("SELECT r.raceResultID AS raceResultID, r.raceResultRank AS raceResultRank, " +
            "r.raceResultBestTime AS raceResultBestTime, r.raceResultCarNo AS raceResultCarNo, " +
            "r.raceResultEvent AS raceResultEvent, r.raceResultEventActivity AS raceResultEventActivity, " +
            "r.driverID AS driverID, r.garageID AS garageID, " +
            "d.driverName AS driverName, d.driverCarMake AS driverCarMake, " +
            "g.garageName AS garageName, g.garageSpeciality AS garageSpeciality " +
            "FROM RaceResult r " +
            "JOIN Driver d ON r.driverID = d.id " +
            "JOIN Garage g ON r.garageID = g.id " +
            "WHERE r.raceResultRank = :raceResultRank")
    List<Map<String, Object>> findByRaceResultRank(@Param("raceResultRank") int raceResultRank);


    // Find by event
    @Query("SELECT r.raceResultID AS raceResultID, r.raceResultRank AS raceResultRank, " +
            "r.raceResultBestTime AS raceResultBestTime, r.raceResultCarNo AS raceResultCarNo, " +
            "r.raceResultEvent AS raceResultEvent, r.raceResultEventActivity AS raceResultEventActivity, " +
            "r.driverID AS driverID, r.garageID AS garageID, " +
            "d.driverName AS driverName, d.driverCarMake AS driverCarMake, " +
            "g.garageName AS garageName, g.garageSpeciality AS garageSpeciality " +
            "FROM RaceResult r " +
            "JOIN Driver d ON r.driverID = d.id " +
            "JOIN Garage g ON r.garageID = g.id " +
            "WHERE r.raceResultEvent= :raceResultEvent")
    List<Map<String, Object>> findByRaceResultEvent(@Param("raceResultEvent") String raceResultEvent);


    // Find by event activity
    @Query("SELECT r.raceResultID AS raceResultID, r.raceResultRank AS raceResultRank, " +
            "r.raceResultBestTime AS raceResultBestTime, r.raceResultCarNo AS raceResultCarNo, " +
            "r.raceResultEvent AS raceResultEvent, r.raceResultEventActivity AS raceResultEventActivity, " +
            "r.driverID AS driverID, r.garageID AS garageID, " +
            "d.driverName AS driverName, d.driverCarMake AS driverCarMake, " +
            "g.garageName AS garageName, g.garageSpeciality AS garageSpeciality " +
            "FROM RaceResult r " +
            "JOIN Driver d ON r.driverID = d.id " +
            "JOIN Garage g ON r.garageID = g.id " +
            "WHERE r.raceResultEventActivity= :raceResultEventActivity")
    List<Map<String, Object>> findByRaceResultEventActivity(@Param("raceResultEventActivity") String raceResultEventActivity);


    // Find by event Year
    @Query("SELECT r.raceResultID AS raceResultID, r.raceResultRank AS raceResultRank, " +
            "r.raceResultBestTime AS raceResultBestTime, r.raceResultCarNo AS raceResultCarNo, " +
            "r.raceResultEvent AS raceResultEvent, r.raceResultEventActivity AS raceResultEventActivity, " +
            "r.driverID AS driverID, r.garageID AS garageID, " +
            "d.driverName AS driverName, d.driverCarMake AS driverCarMake, " +
            "g.garageName AS garageName, g.garageSpeciality AS garageSpeciality " +
            "FROM RaceResult r " +
            "JOIN Driver d ON r.driverID = d.id " +
            "JOIN Garage g ON r.garageID = g.id " +
            "WHERE r.raceResultYear= :raceResultYear")
    List<Map<String, Object>> findByRaceResultYear(@Param("raceResultYear") String raceResultYear);


    // delete race results by race_id
    void deleteByRaceResultID(Long raceResultID);


}

