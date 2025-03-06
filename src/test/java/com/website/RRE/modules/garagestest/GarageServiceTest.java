package com.website.RRE.modules.garagestest;

import com.website.RRE.modules.garages.GarageRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GarageServiceTest {
    @Mock
    @Autowired
    GarageRepository garageRepository;

    @Test
    void findAllGarages() {
    }

    @Test
    void findByGarageName() {
    }

    @Test
    void findByGarageSpeciality() {
    }

    @Test
    void saveGarage() {
    }

    @Test
    void saveAll() {
    }
}