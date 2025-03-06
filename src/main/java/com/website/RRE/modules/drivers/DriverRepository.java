package com.website.RRE.modules.drivers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByDriverName(String driverName);
    List<Driver> findByDriverCarMake(String driverCarMake);
    List<Driver> deleteByDriverID(Long driverID);
    List<Driver> deleteByDriverName(String driverName);

}