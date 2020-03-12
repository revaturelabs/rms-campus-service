package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.repositories.BuildingMongoRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuildingServiceTest {

    BuildingService sut = mock(BuildingService.class);
    BuildingMongoRepository repo = mock(BuildingMongoRepository.class);

    String id = "1";
    Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
            2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

    @Test
    public void testSaveWithValidBuilding() {
        when(repo.save(testBuilding)).thenReturn(testBuilding);
        Building results = sut.save(testBuilding);
    }

    @Test
    public void testFindAll() {
        List<Building> testBuildingList = new ArrayList<>();
        when(repo.findAll()).thenReturn(testBuildingList);
        sut.findAll();
    }

    @Test
    public void testFindByIdWithValidId() {
        when(repo.findById(id)).thenReturn(Optional.of(testBuilding));
        sut.findById(id);
    }

    @Test
    public void testFindByNameWithValidName() {
        String name = "Muma School of Business";
        when(repo.findByName(name)).thenReturn(testBuilding);
        sut.findByName(name);
    }

    @Test
    public void testUpdateWithValidBuilding() {
        when(repo.save(testBuilding)).thenReturn(testBuilding);
        sut.save(testBuilding);
    }

    @Test
    public void testDeleteWithValidId() {
        when(repo.findById(id)).thenReturn(Optional.of(testBuilding));
        sut.delete(id);
    }
}