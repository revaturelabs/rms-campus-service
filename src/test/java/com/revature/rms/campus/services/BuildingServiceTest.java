package com.revature.rms.campus.services;
import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.exceptions.ResourcePersistenceException;
import com.revature.rms.campus.repositories.BuildingMongoRepository;
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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BuildingServiceTest {
    @Mock
    BuildingMongoRepository repo;
    @InjectMocks
    BuildingService sut;
    @Test()
    public void testSaveWithValidBuilding() {
        //Arrange
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        when(repo.save(Mockito.any())).thenReturn(expectedResult);
//Act
        Building actualResults = sut.save(testBuilding);
//Assert
        assertEquals(actualResults, expectedResult);
    }
    @Test(expected = ResourcePersistenceException.class)
    public void testSaveWithNullBuilding(){
//Arrange
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        when(sut.save(Mockito.any())).thenReturn(repo.save(Mockito.any()));
        when(repo.save(Mockito.any())).thenThrow(ResourcePersistenceException.class);
//Act
        Building actualResults = sut.save(null);
//Assert
        //assertEquals(actualResults, expectedResult);
    }

    @Test
    public void testFindAll() {
         Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                 2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        List<Building> mockBuildingList = Arrays.asList(testBuilding);
        when(repo.findAll()).thenReturn(mockBuildingList);
        assertEquals(mockBuildingList, sut.findAll());
    }

    @Test
    public void testFindAllBuildingWithNoCampus() {
        List<Building> mockBuildingList = Collections.emptyList();
        when(repo.findAll()).thenReturn(mockBuildingList);
        assertEquals(mockBuildingList, sut.findAll());
    }


    @Test
    public void findBuildingByIdWithValidId() {
        Optional<Building> expectedResult = Optional.of(new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata()));

        when(repo.findById(Mockito.any())).thenReturn(expectedResult);
        Optional<Building> actualResult = sut.findById("1");
        assertEquals(actualResult, expectedResult);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void findBuildingWithValidIdNotFound() {
        when(repo.findById(Mockito.any())).thenReturn(Optional.empty());
        sut.findById("1");
    }

    @Test(expected = InvalidInputException.class)
    public void findBuildingWithInvalidId() {
        sut.findById(""); sut.findById("0");
        verify(repo.findById("0"), times(0));
    }

    @Test
    public void findBuildingWithValidName() {
        String name = "Muma School of Business";
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findByName(Mockito.any())).thenReturn(expectedResult);
        Building actualResult = sut.findByName(name);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findBuildingWithValidNameUsingAbbreviatedName() {
        String name = "MSB";
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findByName(Mockito.any())).thenReturn(expectedResult);
        Building actualResult = sut.findByName(name);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testUpdateWithValidBuilding() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn((expectedResult));
        Building actualResult = sut.save(testBuilding);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testDeleteWithValidId() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findById(Mockito.any())).thenReturn(Optional.of(testBuilding));
        sut.delete(testBuilding.getId());
        verify(repo, times(1)).deleteById(testBuilding.getId());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteWithInvalidId() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        when(repo.findById(Mockito.any())).thenReturn(Optional.of(testBuilding));
        sut.delete("-24");
        verify(repo, times(0)).deleteById("-24");
    }


}
