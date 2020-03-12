package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.*;
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


import java.util.ArrayList;

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

    @Test
    public void testSaveWithNullBuilding(){

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



//    @Test
//    public void testFindAll() {
//        List<Building> testBuildingList = new ArrayList<>();
//        when(repo.findAll()).thenReturn(testBuildingList);
//        sut.findAll();
//    }
//
//    @Test
//    public void testFindByIdWithValidId() {
//        when(repo.findById(id)).thenReturn(Optional.of(testBuilding));
//        sut.findById(id);
//    }
//
//    @Test
//    public void testFindByNameWithValidName() {
//        String name = "Muma School of Business";
//        when(repo.findByName(name)).thenReturn(testBuilding);
//        sut.findByName(name);
//    }
//
//    @Test
//    public void testUpdateWithValidBuilding() {
//        when(repo.save(testBuilding)).thenReturn(testBuilding);
//        sut.save(testBuilding);
//    }
//
//    @Test
//    public void testDeleteWithValidId() {
//        when(repo.findById(id)).thenReturn(Optional.of(testBuilding));
//        sut.delete(id);
//    }
}
