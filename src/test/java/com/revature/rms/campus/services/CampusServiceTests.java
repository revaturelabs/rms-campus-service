package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CampusServiceTests {

    @Mock
    CampusMongoRepository repo;

    @InjectMocks
    CampusService sut;

    @Test
    public void testSaveWithValidCampus() {

        // Arrange
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(expectedResult);

        // Act
        Campus actualResults = sut.save(testCampus);

        // Assert
        assertEquals(actualResults, expectedResult);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveWithNullCampus() {

        // Arrange
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(expectedResult);

        // Act
        Campus actualResults = sut.save(null);

        // Assert
        assertEquals(actualResults, expectedResult);
    }

    @Test
    public void testFindAll() {
        List<Campus> mockCampusList = new ArrayList<>();
        when(repo.findAll()).thenReturn(mockCampusList);
        assertEquals(mockCampusList, sut.findAll());
    }

    @Test
    public void findCampusByIdWithValidId() {
        Optional<Campus> expectedResult = Optional.of(new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata()));

        when(repo.findById("32")).thenReturn(expectedResult);
        Optional<Campus> actualResult = sut.findById("32");
        assertEquals(actualResult, expectedResult);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void findCampusWithValidIdNotFound() {
        when(repo.findById("21")).thenReturn(Optional.empty());
        sut.findById("21");
    }

    @Test(expected = InvalidInputException.class)
    public void findCampusWithInvalidId() {
        sut.findById(""); sut.findById("0");
        verify(repo.findById("0"), times(0));
    }

    @Test
    public void findCampusWithValidName() {
        String name = "University of South Florida";
        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.findByName(Mockito.any())).thenReturn(expectedResult);
        Campus actualResult = sut.findByName(name);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findCampusWithValidNameUsingAbbreviatedName() {
        String name = "USF";
        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());
        
        when(repo.findByName(name)).thenReturn(expectedResult);
        Campus actualResult = sut.findByName(name);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testUpdateWtihValidCampus() {
        Campus testCampus = new Campus("mocked", "m", new Address(),
                3, 4, 5, new Building[2], new int[4], new ResourceMetadata());

        Campus existingCampus = new Campus("32","University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        Campus excpectedResult = new Campus("mocked", "m", new Address(),
                3, 4, 5, new Building[2], new int[4], new ResourceMetadata());

        when(repo.findById(existingCampus.getId())).thenReturn(Optional.of(excpectedResult));

    }

//
//    @Test
//    public void testUpdateWithValidCampus() {
//        when(repo.save(testCampus)).thenReturn(testCampus);
//        Campus results = sut.save(testCampus);
//        assertEquals(results, sut.save(testCampus));
//    }
//
//    @Test
//    public void testDeleteByIdWithValidId() {
//        when(repo.findById(id)).thenReturn(Optional.of(testCampus));
//        boolean results = sut.delete(id);
//        assertEquals(results, sut.delete(id));
//
//    }
}
