package com.website.RRE.modules.raceresults;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// version 1 db table
// entity layer


@Entity
@Table(name = "rre_race_results", schema="rre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long driverID;

    private int driverRank;
    private int driverCarNo;
    private String driverName;
    private String driverCarMake;
    private int driverBestTime;
}
