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
        Building testBuilding = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata(1, 1,"3.16.2020 10:00 PM", 1, "3.16.2020 10:00 PM", 1, true));

        Building persistedBuilding = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata(1, 1,"3.16.2020 10:00 PM", 1, "3.16.2020 10:00 PM", 1, true));

        when(buildingService.save(Mockito.any())).thenReturn(persistedBuilding);

        assertEquals(buildingController.saveBuilding(testBuilding), persistedBuilding);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveBuildingWithNullBuilding() {
        int id = 1;

        Building expectedResult = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.save(Mockito.any())).thenReturn(expectedResult);
        assertEquals(buildingController.saveBuilding(null), expectedResult);
    }

    public void testGetBuildingByValidId() {
        int id = 1;

        Building expectedResult = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(buildingService.findById(Mockito.any())).thenReturn(Optional.of(expectedResult));
        assertEquals(buildingController.getBuildingById(id), expectedResult);
    }

    public void testGetBuildingByNotFoundId() {
        int id = 1;

        when(buildingService.findById(Mockito.any())).thenReturn(Optional.empty());
        buildingController.getBuildingById(id);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetBuildingWithInvalidBuilding() {
        Building expectedResult = new Building(1, "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        int id = 0; // was ""
        when(buildingService.findById(1)).thenReturn(Optional.of(expectedResult));
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
        ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
        amenityList.add(new Amenity(2, AmenityType.TEA, AmenityStatus.OK));

        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(new Room(1, "2301", 25, new ArrayList<RoomStatus>(5),
                1, new ArrayList<Integer>(3), new ResourceMetadata(1, 1,"3.16.2020 10:00 PM", 1, "3.16.2020 10:00 PM", 1, true)));

        Building testBuilding = new Building(1, "Muma School of Business", "MSB", new Address(1, "4202 E Fowler Ave", "Tampa","Florida","33620", "United States"),
                1, amenityList, roomList, new ResourceMetadata(1, 1,"3.16.2020 10:00 PM", 1, "3.16.2020 10:00 PM", 1, true));

        Mockito.when(buildingService.findById(1)).thenReturn(Optional.of(testBuilding));
        buildingController.deleteBuildingById(testBuilding.getId());
        verify(buildingService, times(1)).delete(testBuilding.getId());
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
