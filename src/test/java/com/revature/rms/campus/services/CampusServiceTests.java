package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


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

    @Test(expected = NullPointerException.class)
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

//    @Test
//    public void testFindAll() {
//        List<Campus> mockCampusList = new ArrayList<>();
//        when(repo.findAll()).thenReturn(mockCampusList);
//        List<Campus> resultsCampusTest = sut.findAll();
//        assertEquals(resultsCampusTest, sut.findAll());
//    }
//
//    @Test
//    public void testFindByIdWithValidId() {
//        when(repo.findById(id)).thenReturn(Optional.of(testCampus));
//        Optional results = sut.findById(id);
//        assertEquals(results, sut.findById(id));
//    }
//
//    @Test
//    public void testFindByNameWithValidName() {
//        String name = "University of South Florida";
//        when(repo.findByName(name)).thenReturn(testCampus);
//        Campus nameResults = sut.findByName(name);
//        assertEquals(nameResults, sut.findByName(name));
//    }
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
