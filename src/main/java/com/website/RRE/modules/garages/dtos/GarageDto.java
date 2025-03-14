package com.website.RRE.modules.garages.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarageDto {
        private Long garageID;
        private String garageName;
        private String garageSpeciality;
}
