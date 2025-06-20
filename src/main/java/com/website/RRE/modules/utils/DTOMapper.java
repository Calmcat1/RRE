package com.website.RRE.modules.utils;


import com.website.RRE.modules.drivers.dtos.DriverDto;
import com.website.RRE.modules.drivers.entities.Driver;
import com.website.RRE.modules.garages.dtos.GarageDto;
import com.website.RRE.modules.garages.entities.Garage;
import com.website.RRE.modules.highlights.dtos.HighlightDto;
import com.website.RRE.modules.raceresults.dtos.RaceResultDto;
import com.website.RRE.modules.raceresults.entities.RaceResult;
import com.website.RRE.modules.highlights.entities.Highlight;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;


@Component
public class DTOMapper {
    // Convert Driver entity to DTO
    public static DriverDto toDriverDTO(Driver driver) {
        return new DriverDto(driver.getDriverID(), driver.getDriverName(), driver.getDriverCarMake());
    }

    // Convert Garage entity to DTO
    public static GarageDto toGarageDTO(Garage garage) {
        return new GarageDto(garage.getGarageID(), garage.getGarageName(), garage.getGarageSpeciality());
    }

    // Convert RaceResult entity to DTO
    public static RaceResultDto toRaceResultDTO(Map<String, Object> raceResult) {
        return new RaceResultDto(
                ((Number) raceResult.get("raceResultID")).longValue(),  // Cast to Number first, then long
                ((Number) raceResult.get("raceResultRank")).intValue(), // Cast to Number first, then int
                ((Number) raceResult.get("raceResultBestTime")).doubleValue(),
                ((Number) raceResult.get("raceResultCarNo")).intValue(),
                (String) raceResult.get("raceResultEvent"),
                (String) raceResult.get("raceResultEventActivity"),
                (Date) raceResult.get("raceResultYear"), // Ensure the database returns a Date object
                ((Number) raceResult.get("driverID")).longValue(),
                ((Number) raceResult.get("garageID")).longValue(),
                (String) raceResult.get("driverName"),
                (String) raceResult.get("garageName"),
                (String) raceResult.get("garageSpeciality")
        );
    }

    // convert entity to map
    public static Map<String, Object> raceResultToMap(RaceResult raceResult) {
        return Map.of(
                "raceResultID", raceResult.getRaceResultID(),
                "raceResultRank", raceResult.getRaceResultRank(),
                "raceResultCarNo", raceResult.getRaceResultCarNo(),
                "raceResultBestTime", raceResult.getRaceResultBestTime(),
                "raceResultEvent", raceResult.getRaceResultEvent(),
                "raceResultEventActivity", raceResult.getRaceResultEventActivity(),
                "raceResultYear", raceResult.getRaceResultYear(),
                "driverID", raceResult.getDriverID(),
                "garageID", raceResult.getGarageID()
        );
    }


    // Convert Highlight entity to DTO
    public static HighlightDto toHighlightDTO(Highlight highlight) {
        return new HighlightDto(highlight.getHighlightID(), highlight.getHighlightHeading(), highlight.getHighlightDescription(), highlight.getHighlightImagePath(), highlight.getHighlightDate());
    }
}
