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

@RunWith(SpringJUnit4ClassRunner.class)
public class CampusControllerTest {

    @InjectMocks
    private CampusController campusController;

    @Mock
    private CampusService campusService;

    @Test
    public void testFindAllCampusWithValidCampus() {
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        List<Campus> testCampusList = Arrays.asList(testCampus);

        when(campusService.findAll()).thenReturn(testCampusList);

        assertEquals(campusController.getAllCampus(), testCampusList);
    }

    @Test
    public void testFindAllCampusWithNoCampuses() {

        List<Campus> testListCampus = Collections.emptyList();

        when(campusService.findAll()).thenReturn(testListCampus);

        assertEquals(campusController.getAllCampus(), testListCampus);
    }

    @Test
    public void testSaveCampusWithValidCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());
        Campus persistedCampus = new Campus("32","University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<>(3), new ResourceMetadata());

        when(campusService.save(Mockito.any())).thenReturn(persistedCampus);

        assertEquals(campusController.saveCampus(testCampus), persistedCampus);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveCampusWithNullCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.save(Mockito.any())).thenReturn(expectedResult);
        assertEquals(campusController.saveCampus(null), expectedResult);
    }

    @Test
    public void testGetCampusByValidId() {
        String id = "32";
        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.findById(Mockito.any())).thenReturn(Optional.of(expectedResult));
        assertEquals(campusController.getCampusById(id),  expectedResult);
    }

    @Test (expected = ResourceNotFoundException.class)
    public void testGetCampusWithByIdNotFound() {
        String id = "21";
        when(campusService.findById(Mockito.any())).thenReturn(Optional.empty());
        campusController.getCampusById(id);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetCampusWithInvalidCampus() {
        String id = "";
        when(campusService.findById(Mockito.any())).thenReturn(null);
        assertEquals(campusController.getCampusById(id), null);
    }

    @Test
    public void testUpdateCampusWithValidCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.update(Mockito.any())).thenReturn(expectedResult);
        assertEquals(campusController.updateCampus(testCampus), expectedResult);
    }

    @Test
    public void testDeleteCampusWithValidId() {
        Campus testCampus = new Campus("32","University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        when(campusService.findById(Mockito.any())).thenReturn(Optional.of(testCampus));
        campusController.deleteCampusById(testCampus.getId());
        verify(campusService, times(1)).delete(testCampus.getId());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteCampusWithInvalidId() {
        Campus testCampus = new Campus("32","University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1), new ArrayList<Integer>(3), new ResourceMetadata());

        String testId = "-1";
        when(campusService.findById(Mockito.any())).thenReturn(Optional.of(testCampus));
        campusController.deleteCampusById(testId);
        verify(campusService, times(0)).delete(testId);
    }
}
