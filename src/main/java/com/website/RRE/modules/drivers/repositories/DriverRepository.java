package com.website.RRE.modules.drivers.repositories;


import com.website.RRE.modules.drivers.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByDriverName(String driverName);
    List<Driver> findByDriverCarMake(String driverCarMake);
    void deleteByDriverID(Long driverID);
    void deleteByDriverName(String driverName);

}