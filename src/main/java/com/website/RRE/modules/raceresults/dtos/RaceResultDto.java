package com.website.RRE.modules.raceresults.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaceResultDto {
        private Long raceResultID;
        private Integer raceResultRank;
        private Double raceResultBestTime;
        private Integer raceResultCarNo;
        private String raceResultEvent;
        private String raceResultEventActivity;
        private Date raceResultYear;
        private Long driverID;
        private Long garageID;
        private String garageName;
        private String driverName;
        private String garageSpeciality;
}
