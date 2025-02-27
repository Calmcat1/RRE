package com.website.RRE.modules.raceresults;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private long raceResultID;

    @JsonProperty("raceResultRank")
    private int raceResultRank;

    @JsonProperty("raceResultBestTime")
    private int raceResultBestTime;

    @JsonProperty("raceResultCarNo")
    private int raceResultCarNo;
}
