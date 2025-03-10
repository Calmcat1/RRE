package com.website.RRE.modules.raceresults.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


// version 2 db table
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
    private double raceResultBestTime;

    @JsonProperty("raceResultCarNo")
    private int raceResultCarNo;

    @JsonProperty("raceResultEvent")
    private String raceResultEvent;

    @JsonProperty("raceResultEventActivity")
    private String raceResultEventActivity;

    @JsonProperty("raceResultYear")
    private Date raceResultYear;

    // input here references driverID in driver table
    @JsonProperty("driverID")
    private Long driverID;

    // input here references garageID in garage table
    @JsonProperty("garageID")
    private Long garageID;

//    // rre_driver table for join
//    @ManyToOne
//    @JoinColumn(name = "driver_id", referencedColumnName = "garage_id")
//    private Driver driver;
//
//    // garage table
//    @ManyToOne
//    @JoinColumn(name = "garage_id", referencedColumnName = "garage_id")
//    private Garage garage;




}
