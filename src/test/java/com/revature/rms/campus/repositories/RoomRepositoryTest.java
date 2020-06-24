//package com.revature.rms.campus.repositories;
//
//import com.revature.rms.campus.entities.Room;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class RoomMongoRepositoryTest {
//    @Autowired
//    private RoomMongoRepository sut;
//    @BeforeEach
//    public void setup() throws Exception {
//        Room room1 = new Room("2301D", 45, true, null, "1", null, null);
//        Room room2 = new Room("84230", 100, true, null, "2", null, null);
//        //save product, verify has ID value after save
//        assertNull(room1.getId());
//        assertNull(room2.getId());
//        this.sut.save(room1);
//        this.sut.save(room2);
//        assertNotNull(room1.getId());
//        assertNotNull(room2.getId());
//    }
//    @Test
//    public void testFindAll() {
//        Iterable<Room> rooms = sut.findAll();
//        int count = 0;
//        for(Room p : rooms) {
//            count++;
//        }
//        assertEquals(19, count);
//    }
//    @Test
//    public void testFindById() {
//        Optional<Room> room1 = sut.findByRoomNumber("2301D");
//        assertTrue(room1.isPresent());
//        Optional<Room> room2 = sut.findById(room1.get().getId());
//        assertTrue(room2.isPresent());
//        assertEquals( room1.get(), room2.get() );
//    }
//    @Test
//    public void testUpdate() {
//        Optional<Room> room1 = sut.findByRoomNumber("2301D");
//        assertTrue(room1.isPresent());
//        room1.get().setActive(false);
//        sut.save(room1.get());
//        Optional<Room> room2 = sut.findByRoomNumber("2301D");
//        assertTrue(room1.isPresent());
//        assertTrue(!room2.get().getActive());
//    }
//    @Test
//    public void testDelete() {
//        Optional<Room> room1 = sut.findByRoomNumber("2301D");
//        assertTrue(room1.isPresent());
//        this.sut.delete(room1.get());
//        Optional<Room> room2 = sut.findByRoomNumber("2301D");
//        assertFalse(room2.isPresent());
//    }
//    @AfterEach
//    public void tearDown() throws Exception {
//        this.sut.deleteAll();
//    }
//}
