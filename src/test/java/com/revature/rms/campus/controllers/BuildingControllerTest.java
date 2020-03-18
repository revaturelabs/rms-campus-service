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

@RunWith(SpringJUnit4ClassRunner.class)
public class BuildingControllerTest {
    @InjectMocks
    private BuildingController buildingController;

    @Mock
    private BuildingService buildingService;

    @Test
    public void testFindAllBuildingWithValidBuilding() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
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
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        Building persistedBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.save(Mockito.any())).thenReturn(persistedBuilding);

        assertEquals(buildingController.saveBuilding(testBuilding), persistedBuilding);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveBuildingWithNullBuilding() {
        String id = "1";

        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.save(Mockito.any())).thenReturn(expectedResult);
        assertEquals(buildingController.saveBuilding(null), expectedResult);
    }

    public void testGetBuildingByValidId() {
        String id = "1";

        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.findById(Mockito.any())).thenReturn(Optional.of(expectedResult));
        assertEquals(buildingController.getBuildingById(id), expectedResult);
    }

    public void testGetBuildingByNotFoundId() {
        String id = "1";

        when(buildingService.findById(Mockito.any())).thenReturn(Optional.empty());
        buildingController.getBuildingById(id);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetBuildingWithInvalidBuilding() {
        String id = "";
        when(buildingService.findById(Mockito.any())).thenReturn(null);
        assertEquals(buildingController.getBuildingById(id), null);
    }

    @Test
    public void testUpdateBuildingWithValidBuilding() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.update(Mockito.any())).thenReturn(expectedResult);
        assertEquals(buildingController.updateBuilding(testBuilding), expectedResult);
    }

    @Test
    public void testDeleteBuildingWithValidId() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.findById(Mockito.any())).thenReturn(Optional.of(testBuilding));
        buildingController.deleteBuildingById(testBuilding.getId());
        verify(buildingService, times(1)).delete(testBuilding.getId());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteBuildingWithInvalidId() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

                String testId = "-1";
        when(buildingService.findById(Mockito.any())).thenReturn(Optional.of(testBuilding));
        buildingController.deleteBuildingById(testId);
        verify(buildingService, times(0)).delete(testId);
    }
}
