package com.revature.rms.campus.services;
import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.exceptions.ResourcePersistenceException;
import com.revature.rms.campus.repositories.BuildingMongoRepository;
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

    /**
     * testSaveWithValidBuilding() ensures BuildingService.save() is functioning properly with the valid or correct input.
     * A non-null building object should be returned.
     */
    @Test
    public void testSaveWithValidBuilding() {

        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(expectedResult);

        Building actualResults = sut.save(testBuilding);

        assertEquals(actualResults, expectedResult);
    }

    /**
     * testSaveWithNullBuilding() ensures BuildingService.save() will not work if a null building object is being saved.
     * If the building object is null, a ResourceNotFoundException will be thrown since the method does not meet the
     * desired criteria for the method to execute properly.
     */
    @Test(expected = ResourcePersistenceException.class)
    public void testSaveWithNullBuilding(){

        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        when(sut.save(Mockito.any())).thenReturn(repo.save(Mockito.any()));
        when(repo.save(Mockito.any())).thenThrow(ResourcePersistenceException.class);

        Building actualResults = sut.save(null);

    }

    /**
     * testFindAll() ensures BuildingService().findAll() returns a list of all the existing Building objects.
     */
    @Test
    public void testFindAll() {
         Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                 2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        List<Building> mockBuildingList = Arrays.asList(testBuilding);
        when(repo.findAll()).thenReturn(mockBuildingList);
        assertEquals(mockBuildingList, sut.findAll());
    }

    /**
     * testFindAllBuildingWithNoCampus() returns an empty list rather than returning null, thus avoiding a potential
     * NullPointerException in the future.
     */
    @Test
    public void testFindAllBuildingWithNoCampus() {
        List<Building> mockBuildingList = Collections.emptyList();
        when(repo.findAll()).thenReturn(mockBuildingList);
        assertEquals(mockBuildingList, sut.findAll());
    }

    /**
     * findBuildingByIdWithValidId() ensures BuildingService.findById() returns the object containing the same id as the one provided.
     */
    @Test
    public void findBuildingByIdWithValidId() {
        Optional<Building> expectedResult = Optional.of(new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata()));

        when(repo.findById(Mockito.any())).thenReturn(expectedResult);
        Optional<Building> actualResult = sut.findById("1");
        assertEquals(actualResult, expectedResult);
    }

    /**
     * findBuildingWithValidIdNotFound() throws a ResourceNotFoundException when provided a correct id but,
     * there is no building associated with it.
     */
    @Test(expected = ResourceNotFoundException.class)
    public void findBuildingWithValidIdNotFound() {
        when(repo.findById(Mockito.any())).thenReturn(Optional.empty());
        sut.findById("1");
    }

    /**
     * findBuildingWithInvalidId() throws an InvalidInputException when the provided id is less than or equal to zero or
     * empty, that is the provided field is empty.
     */
    @Test(expected = InvalidInputException.class)
    public void findBuildingWithInvalidId() {
        sut.findById(""); sut.findById("0");
        verify(repo.findById("0"), times(0));
    }

    /**
     * findBuildingWithValidName() returns the object containing the same building name as the one provided.
     */
    @Test
    public void findBuildingWithValidName() {
        String name = "Muma School of Business";
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findByName(Mockito.any())).thenReturn(expectedResult);
        Building actualResult = sut.findByName(name);

        assertEquals(expectedResult, actualResult);
    }

    /**
     * findBuildingByTrainingLead() returns an object containing the same trainer id as the one provided.
     */
    @Test
    public void findBuildingByTrainingLead() {
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findByTrainingLead(Mockito.any())).thenReturn(expectedResult);
        Building actualResult = sut.findByTrainingLeadId(2);

        assertEquals(expectedResult, actualResult);
    }

    /**
     * findBuildingByTrainingLeadInvalidId() throws an InvalidInputException when the provided id is less than or equal to zero.
     */
    @Test(expected = InvalidInputException.class)
    public void findBuildingByTrainingLeadInvalidId() {
        Building actualResult = sut.findByTrainingLeadId(0);
    }

    /**
     * findBuildingByTrainingLeadIdNotPresent() throws a ResourceNotFoundException when provided a trainer id
     * that is a correct value but is not associated with any buildings.
     */
    @Test(expected = ResourceNotFoundException.class)
    public void findBuildingByTrainingLeadIdNotPresent() {
        when(repo.findByTrainingLead(Mockito.any())).thenReturn(null);
        Building actualResult = sut.findByTrainingLeadId(100);
    }

    /**
     * findBuildingWithValidNameUsingAbbreviatedName() returns the object containing the same abbreviated building name
     * as the one provided.
     */
    @Test
    public void findBuildingWithValidNameUsingAbbreviatedName() {
        String name = "MSB";
        Building expectedResult = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findByName(Mockito.any())).thenReturn(expectedResult);
        Building actualResult = sut.findByName(name);
        assertEquals(expectedResult, actualResult);
    }

    /**
     * testUpdateWithValidBuilding() passes in a building object with changed fields to the buildingMongoRepository.save() to
     * persist the changes and return the updated saved building object. There is no need for a null building check since the
     * object already exists.
     */
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

    /**
     * testDeleteWithValidId() ensures buildingService.delete() functions by verifying buildingMongoRepository.deleteById() is ran
     * successfully one time when provided with a valid id.
     */
    @Test
    public void testDeleteWithValidId() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());

        when(repo.findById(Mockito.any())).thenReturn(Optional.of(testBuilding));
        sut.delete(testBuilding.getId());
        verify(repo, times(1)).deleteById(testBuilding.getId());
    }

    /**
     * testDeleteWithInvalidId() ensures that buildingMongoRepository.deleteById() is not run when provided an invalid id.
     * Instead it throws an InvalidInputException.
     */
    @Test(expected = InvalidInputException.class)
    public void testDeleteWithInvalidId() {
        Building testBuilding = new Building("1", "Muma School of Business", "MSB", new Address(),
                2, new ArrayList<Amenity>(1), new ArrayList<Room>(3), new ResourceMetadata());
        when(repo.findById(Mockito.any())).thenReturn(Optional.of(testBuilding));
        sut.delete("-24");
        verify(repo, times(0)).deleteById("-24");
    }


}
