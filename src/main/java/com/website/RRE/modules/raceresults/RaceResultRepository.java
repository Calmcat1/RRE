package com.website.RRE.modules.raceresults;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// repository layer

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> findByDriverName(String driverName);
    List<RaceResult> findByDriverCarNo(int driverCarNo);
    List<RaceResult> findByDriverRank(int driverRank);
}

