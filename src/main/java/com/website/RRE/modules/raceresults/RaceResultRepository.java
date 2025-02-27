package com.website.RRE.modules.raceresults;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// repository layer

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> findByRaceResultBestTime(int raceResultBestTime);
    List<RaceResult> findByRaceResultCarNo(int raceResultCarNo);
    List<RaceResult> findByRaceResultRank(int raceResultRank);
}

