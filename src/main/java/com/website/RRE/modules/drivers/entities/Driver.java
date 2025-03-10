package com.website.RRE.modules.drivers.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "rre_drivers", schema="rre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("driverID")
    private Long driverID;

    @JsonProperty("driverName")
    private String driverName;

    @JsonProperty("driverCarMake")
    private String driverCarMake;


}
