package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BuildingMongoRepositoryTest {
    @Autowired
    private BuildingMongoRepository sut;
    @BeforeAll
    public void setup() throws Exception {
        Building building1 = new Building("NEC", "NEC", new Address(), 1, null, null, null);
        Building building2 = new Building("BCN", "BCN", new Address(), 2, null, null, null);
        //save product, verify has ID value after save
        assertNull(building1.getId());
        assertNull(building2.getId());
        this.sut.save(building1);
        this.sut.save(building2);
        assertNotNull(building1.getId());
        assertNotNull(building2.getId());
    }
    @Test
    public void testFindAll() {
        Iterable<Building> buildings = sut.findAll();
        int count = 0;
        for(Building p : buildings) {
            count++;
        }
        assertEquals(count, 2);
    }
    @Test
    public void testFindByNameAndFindById() {
        Building building1 = sut.findByName("NEC");
        assertNotNull(building1);
        Building building2 = sut.findById(building1.getId()).get();
        assertNotNull(building2);
        assertEquals( building1, building2 );
    }
    @Test
    public void testUpdate() {
        Building building1 = sut.findByName("NEC");
        building1.setAbbrName("PogChamp");
        sut.save(building1);
        Building building2 = sut.findByName("NEC");
        assertNotNull(building2);
        assertEquals("PogChamp", building2.getAbbrName());
    }
    @Test
    public void testDelete() {
        Building building1 = sut.findByName("NEC");
        this.sut.delete(building1);
        Building building2 = sut.findByName("NEC");
        assertNull(building2);
    }
    @AfterAll
    public void tearDown() throws Exception {
        this.sut.deleteAll();
    }
}
