package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
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
public class CampusControllerTest {

    @InjectMocks
    private CampusController campusController;

    @Mock
    private CampusService campusService;

    @Test
    public void testFindAllCampusWithValidCampus() {
        Campus testCampus = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        List<Campus> testCampusList = Arrays.asList(testCampus);

        when(campusService.findAll()).thenReturn(testCampusList);

        assertEquals(campusController.getAllCampuses(), testCampusList);
    }

    @Test
    public void testFindAllCampusWithNoCampuses() {

        List<Campus> testListCampus = Collections.emptyList();

        when(campusService.findAll()).thenReturn(testListCampus);

        assertEquals(campusController.getAllCampuses(), testListCampus);
    }

    @Test
    public void testSaveCampusWithValidCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());
        Campus persistedCampus = new Campus(32,"University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<>(3), new ResourceMetadata());

        when(campusService.save(Mockito.any())).thenReturn(persistedCampus);

        assertEquals(campusController.saveCampus(testCampus), persistedCampus);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveCampusWithNullCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.save(Mockito.any())).thenReturn(expectedResult);
        assertEquals(campusController.saveCampus(null), expectedResult);
    }

    @Test
    public void testGetCampusByValidId() {
        int id = 32;
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.findById(Mockito.anyInt())).thenReturn(expectedResult);

        assertEquals(campusController.getCampusById(id),  expectedResult);
    }

    @Test (expected = ResourceNotFoundException.class)
    public void testGetCampusWithByIdNotFound() {
        int id = 21;

        when(campusService.findById(Mockito.any(Integer.class))).thenReturn(null);

        campusController.getCampusById(id);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetCampusWithInvalidCampus() {

        int id = 0;
        when(campusService.findById(Mockito.any(Integer.class))).thenReturn(null);

        assertEquals(campusController.getCampusById(id), null);
    }

    @Test
    public void testUpdateCampusWithValidCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.update(Mockito.any(Campus.class))).thenReturn(expectedResult);

        assertEquals(campusController.updateCampus(testCampus), expectedResult);
    }

    @Test
    public void testDeleteCampusWithValidId() {
        Campus testCampus = new Campus(32,"University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.findById(Mockito.any(Integer.class))).thenReturn(testCampus);
        campusController.deleteCampusById(testCampus.getId());
        verify(campusService, times(1)).delete(testCampus.getId());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteCampusWithInvalidId() {
        Campus testCampus = new Campus(32,"University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        int testId = -1;
        when(campusService.findById(Mockito.any(Integer.class))).thenReturn(testCampus);
        campusController.deleteCampusById(testId);
        verify(campusService, times(0)).delete(testId);
    }

    @Test
    public void testGetCampusByTrainingManagerId() {

        List<Campus> campuses = new ArrayList<>();
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(), new ArrayList<Integer>(), new ResourceMetadata());
        campuses.add(expectedResult);
        List<Campus> result = campuses;
        when(campusService.findByTrainingManagerId(Mockito.any(Integer.class))).thenReturn(campuses);
        assertEquals(campusController.getCampusByTrainingManagerId(2),  result);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetCampusByTrainingManagerIdWithNull() {
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.findByTrainingManagerId(5)).thenThrow(new ResourceNotFoundException());
        campusController.getCampusByTrainingManagerId(5);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetCampusByTrainingManagerIdInvalid() {
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());
        campusController.getCampusByTrainingManagerId(0);
    }

    @Test
    public void testGetCampusByStagingManagerId() {

        List<Campus> campuses= new ArrayList<>();
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        campuses.add(expectedResult);
        when(campusService.findByStagingManagerId(Mockito.any())).thenReturn(campuses);
        assertEquals(campusController.getCampusByStagingManagerId(3),  campuses);

    }

    @Test(expected =  ResourceNotFoundException.class)
    public void testGetCampusByStagingManagerIdWithNull() {
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.findByStagingManagerId(5)).thenThrow(new ResourceNotFoundException());
        campusController.getCampusByStagingManagerId(5);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetCampusByStagingManagerIdInvalid() {
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());
        campusController.getCampusByStagingManagerId(0);
    }

    @Test
    public void testGetCampusListByResourceOwnerId() {
        int id = 1;
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata(1,1,"",1,"",1,true));
        List<Campus> result = new ArrayList<>();
        result.add(expectedResult);
        when(campusService.findByResourceOwnerId(Mockito.anyInt())).thenReturn(result);
        assertEquals(campusController.getByResourceOwnerId(id), result);

    }

    @Test(expected = InvalidInputException.class)
    public void testGetCampusListByInvalidResourceOwnerId() {
        int id = -1;
        Campus expectedResult = new Campus(32, "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata(1,1,"",1,"",1,true));
        List<Campus> result = new ArrayList<>();
        result.add(expectedResult);
        when(campusService.findByResourceOwnerId(Mockito.anyInt())).thenThrow(new InvalidInputException());
        assertEquals(campusController.getByResourceOwnerId(id), result);

    }
}
