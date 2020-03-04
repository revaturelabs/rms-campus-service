package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CampusServiceTests {

    CampusService sut = mock(CampusService.class);
    CampusMongoRepository repo = mock(CampusMongoRepository.class);

    @Test
    public void testSaveWithValidCampus() {
        Campus testCampus = new Campus("1", "University South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.save(testCampus)).thenReturn(testCampus);
        sut.save(testCampus);
    }

    @Test
    public void testFindAll() {
        List<Campus> mockCampusList = new ArrayList<>();
        when(repo.findAll()).thenReturn(mockCampusList);
        sut.findAll();
    }

    @Test
    public void testFindByIdWithValidId() {
        String id = "32";
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.findById(id)).thenReturn(Optional.of(testCampus));
        sut.findById(id);
    }

    @Test
    public void testFindByNameWithValidName() {
        String name = "University of South Florida";
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.findByName(name)).thenReturn(testCampus);
        sut.findByName(name);
    }

    @Test
    public void testUpdateWithValidCampus() {
        Campus testCampus = new Campus("University South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.save(testCampus)).thenReturn(testCampus);
        sut.save(testCampus);
    }

    @Test
    public void testDeleteByIdWithValidId() {
        String id = "32";
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(repo.findById(id)).thenReturn(Optional.of(testCampus));
        sut.delete(id);
    }
    
}
