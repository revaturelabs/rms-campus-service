package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuildingRepositoryTest {

    @Autowired
    private BuildingRepository sut;

//    @BeforeEach
//    public void setup() throws Exception {
//        Building building1 = new Building("NEC", "NEC", new Address(), 1, null, null, null);
//        Building building2 = new Building("BCN", "BCN", new Address(), 2, null, null, null);
//        //save product, verify has ID value after save
//        this.sut.save(building1);
//        this.sut.save(building2);
//    }
    @AfterEach
    public void tearDown() throws Exception {
        this.sut.deleteAll();
    }
    @org.junit.Test
    public void testSaveBuilding() {
        Building building = new Building("Test", "TEST", new Address(1,"","","","",""), 10, null, null, null);
        sut.save(building);

        Building result = sut.findByTrainingLead(10);
        assertThat(result).isNotNull();

        assertThat(result.getAbbrName()).isEqualTo("TEST");
    }
//
//    @org.junit.Test
//    public void testFindAll() {
//        //Iterable<Building> buildingList = sut.findAll();
//        Building building = new Building("Test1", "TEST1", new Address(10,"asd","asd","asd","asd","asd"), 12, null, null, null);
//        Building building2 = new Building("Test2", "TEST2", new Address(11,"asdf","asdf","asdf","asdf","asdf"), 13, null, null, null);
//        sut.save(building);
//        sut.save(building2);
//        int originalCount = 0;
//        int testCount = 0;
//        Iterable<Building> buildingList2 = sut.findAll();
////        for (Building b : buildingList) {
////            originalCount++;
////        }
//        for (Building b : buildingList2) {
//            testCount++;
//        }
//        assertThat(originalCount).isEqualTo(testCount+2);
//
//    }
//    @Test
//    public void testFindByNameAndFindById() {
//        Building building1 = sut.findByName("NEC");
//        assertNotNull(building1);
//        Building building2 = sut.findById(building1.getId()).get();
//        assertNotNull(building2);
//        assertEquals( building1, building2 );
//    }
//    @Test
//    public void testUpdate() {
//        Building building1 = sut.findByName("NEC");
//        assertNotNull(building1);
//        building1.setAbbrName("PogChamp");
//        sut.save(building1);
//        Building building2 = sut.findByName("NEC");
//        assertNotNull(building2);
//        assertEquals("PogChamp", building2.getAbbrName());
//    }
//    @Test
//    public void testDelete() {
//        Building building1 = sut.findByName("NEC");
//        this.sut.delete(building1);
//        Building building2 = sut.findByName("NEC");
//        assertNull(building2);
//    }

}
