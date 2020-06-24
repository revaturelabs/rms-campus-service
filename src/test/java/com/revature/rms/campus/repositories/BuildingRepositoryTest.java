//package com.revature.rms.campus.repositories;
//
//import com.revature.rms.campus.entities.*;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class BuildingRepositoryTest {
//    @Autowired
//    private BuildingRepository sut;
//    @Autowired
//    private AddressRepository sutAddress;
//    @Autowired
//    private ResourceMetadataRepository sutMeta;
//    @Autowired
//    private RoomRepository sutRoom;
//
//    @BeforeEach
//    public void setup() throws Exception {
//
//        ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
//        amenityList.add(new Amenity(AmenityType.TEA, AmenityStatus.OK));
//        ArrayList<Amenity> amenityList1 = new ArrayList<Amenity>();
//        amenityList.add(new Amenity(AmenityType.TEA, AmenityStatus.OK));
//        Address address = new Address("4202 E Fowler Ave", "Tampa","Florida","33620", "United States");
//        ResourceMetadata rmd = new ResourceMetadata( 1,"3.16.2020 10:00 PM", 1, "3.16.2020 10:00 PM", 1, true);
//        ArrayList<Room> roomList = new ArrayList<Room>();
//        Room saveroom = new Room("107", 24, new ArrayList<RoomStatus>(), 3, new ArrayList<Integer>(), rmd);
//        roomList.add(saveroom);
//        Building building1 = new Building("Muma", "MSB", address, 2, null, roomList, rmd);
//        Building building2 = new Building("Muma2", "MSB", address, 2, null, roomList, rmd);
//        //Building building2 = new Building("BCN", "BCN", new Address(1, "4202 E Fowler Ave", "Tampa","Florida","33620", "United States"), 2, null, null, null);
//        //save product, verify has ID value after save
////        assertNull(building1.getId());
////        assertNull(building2.getId());
//
//        this.sutMeta.save(rmd);
//        this.sutRoom.save(saveroom);
//        this.sutAddress.save(address);
//        this.sut.save(building1);
//        this.sut.save(building2);
////        assertNotNull(building1.getId());
////        assertNotNull(building2.getId());
//    }
//    @Test
//    public void testFindAll() {
//        Iterable<Building> buildings = sut.findAll();
//        int count = 0;
//        for(Building p : buildings) {
//            count++;
//        }
//        assertEquals(4, count);
//    }
//    @Test
//    public void testFindByNameAndFindById() {
//        Building building1 = sut.findByName("Muma");
//        assertNotNull(building1);
//        Building building2 = sut.findById(building1.getId()).get();
//        assertNotNull(building2);
//        assertEquals( building1, building2 );
//    }
//    @Test
//    public void testUpdate() {
//        Building building1 = sut.findByName("Muma");
//        assertNotNull(building1);
//        building1.setAbbrName("PogChamp");
//        sut.save(building1);
//        Building building2 = sut.findByName("Muma");
//        assertNotNull(building2);
//        assertEquals("PogChamp", building2.getAbbrName());
//    }
//    @Test
//    public void testDelete() {
//        Building building1 = sut.findByName("Muma");
//        this.sut.delete(building1);
//        Building building2 = sut.findByName("Muma");
//        assertNull(building2);
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        this.sut.deleteAll();
//    }
//}
