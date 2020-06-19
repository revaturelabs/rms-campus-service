package com.revature.rms.campus.controllers;
import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.services.BuildingService;
import com.revature.rms.campus.services.CampusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
/**
 * These tests are for additional validation and to ensure the CampusService methods are working successfully when called
 * by the CampusController methods. See CampusServiceTests for more details on testing for CampusService methods.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class BuildingControllerTest {
    @InjectMocks
    private BuildingController buildingController;

    @Mock
    private BuildingService buildingService;

    @Test
    public void testFindAllBuildingWithValidBuilding() {
        Building testBuilding = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        List<Building> testBuildingList = Arrays.asList(testBuilding);

        when(buildingService.findAll()).thenReturn(testBuildingList);

        assertEquals(buildingController.getAllBuildings(), testBuildingList);
    }

    @Test
    public void testFindAllBuildingWithNoBuilding() {

        List<Building> testBuildingList = Collections.emptyList();

        when(buildingService.findAll()).thenReturn(testBuildingList);

        assertEquals(buildingController.getAllBuildings(), testBuildingList);
    }

    @Test
    public void testSaveBuildingWithValidBuilding() {
        Building testBuilding = new Building("Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        Building persistedBuilding = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.save(testBuilding)).thenReturn(persistedBuilding);

        assertEquals(buildingController.saveBuilding(testBuilding), persistedBuilding);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveBuildingWithNullBuilding() {
        String id = "1";

        Building expectedResult = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.save(Mockito.any())).thenReturn(expectedResult);
        assertEquals(buildingController.saveBuilding(null), expectedResult);
    }

    @Test
    public void testGetBuildingByValidId() {
        int id = 1;

        Building expectedResult = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(), new ArrayList<Room>(), new ResourceMetadata());

        when(buildingService.findById(1)).thenReturn(Optional.of(expectedResult));
        assertEquals(buildingController.getBuildingById(id), expectedResult);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetBuildingByNotFoundId() {
        int id = 1;

        when(buildingService.findById(1)).thenThrow(new ResourceNotFoundException());
        buildingController.getBuildingById(id);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetBuildingWithInvalidBuilding() {
        int id = 0;
        when(buildingService.findById(id)).thenReturn(null);
        assertEquals(buildingController.getBuildingById(id), null);
    }

    @Test
    public void testUpdateBuildingWithValidBuilding() {
        Building testBuilding = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        Building expectedResult = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.update(Mockito.any())).thenReturn(expectedResult);
        assertEquals(buildingController.updateBuilding(testBuilding), expectedResult);
    }

    @Test
    public void testDeleteBuildingWithValidId() {
        int id = 1;

        buildingController.deleteBuildingById(id);
        verify(buildingService, times(1)).delete(id);
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteBuildingWithInvalidId() {
        Building testBuilding = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

                int testId = -1;
        when(buildingService.findById(testId)).thenReturn(Optional.of(testBuilding));
        buildingController.deleteBuildingById(testId);
        verify(buildingService, times(0)).delete(testId);
    }
}
