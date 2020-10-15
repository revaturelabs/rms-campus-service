package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.entities.RoomStatus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.repositories.RoomRepository;
import com.revature.rms.campus.repositories.RoomStatusRepository;
import com.revature.rms.core.metadata.*;
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
public class RoomServiceTest {

    @Mock
    RoomRepository repo;

    @Mock
    RoomStatusRepository roomStatusRepository;

    @InjectMocks
    RoomService sut;

    //Spies
    RoomService spyService = new RoomService();
    RoomStatus spyStatus = new RoomStatus();

    //Test Data
    List<Room> testRooms;
    Room nullRoom;
    ArrayList<Integer> workorders;
    ArrayList<RoomStatus> testStatuses;

    @Before
    public void setup() {
        //Room statuses
        RoomStatus s1 = new RoomStatus(1, false, false, "Jan 28, 2020", 1, "And So It Begins...");
        RoomStatus s2 = new RoomStatus(2, true, false, "Jan 29, 2020", 1, "And Where it Is...");
        RoomStatus s3 = new RoomStatus(3, false, true, "Jan 30, 2020", 1, "And How It Ends...");
        testStatuses = new ArrayList<>();
        testStatuses.add(s1);
        testStatuses.add(s2);
        testStatuses.add(s3);

        //Work Orders
        workorders = new ArrayList<>();
        workorders.add(1);
        workorders.add(2);
        workorders.add(3);

        //Rooms
        Room r1 = new Room(1, "404", 1, testStatuses, 1, workorders, new ResourceMetadata());
        Room r2 = new Room(2, "606", 25, testStatuses, 2, workorders, new ResourceMetadata());
        Room r3 = new Room(3, "808", 300, testStatuses, 3, workorders, new ResourceMetadata());
        testRooms = new ArrayList<>();
        testRooms.add(r1);
        testRooms.add(r2);
        testRooms.add(r3);

        //Spies
        spyService = spy(spyService);
        spyStatus = spy(spyStatus);

    }

    @After
    public void tearDown() {
        testStatuses = null;
        workorders = null;
        testRooms = null;
    }

    @Test
    public void testSaveRoom() {
        when(repo.save(testRooms.get(0))).thenReturn(testRooms.get(0));
        assertEquals(testRooms.get(0), sut.save(testRooms.get(0)));
    }

//    @Test
//    public void testSaveRoomSpy() {
//        when(repo.save(testRooms.get(0))).thenReturn(testRooms.get(0));
//    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveRoomNullRoom() {
        sut.save(nullRoom);
    }

    @Test
    public void testGetAllRooms() {
        when(repo.findAll()).thenReturn(testRooms);
        assertEquals(testRooms, sut.findAll());
    }

    @Test
    public void testGetById() {
        when(repo.findById(testRooms.get(0).getId())).thenReturn(Optional.ofNullable(testRooms.get(0)));
        assertEquals(Optional.ofNullable(testRooms.get(0)), sut.findById(testRooms.get(0).getId()));
    }

    @Test(expected = InvalidInputException.class)
    public void testGetByIdFailed() {
        int id = 0;
        sut.findById(id);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdNotFound() {
        when(sut.findById(99999)).thenThrow(ResourceNotFoundException.class);
    }

    @Test
    public void testGetByRoomNumber() {
        when(repo.findByRoomNumber(testRooms.get(0).getRoomNumber())).thenReturn(Optional.ofNullable(testRooms.get(0)));
        assertEquals(Optional.ofNullable(testRooms.get(0)), sut.findByRoomNumber(testRooms.get(0).getRoomNumber()));
    }

    @Test(expected = InvalidInputException.class)
    public void testGetByRoomNumberNoRoom() {
        when(sut.findByRoomNumber("")).thenThrow(InvalidInputException.class);
    }
    
    @Test(expected = InvalidInputException.class)
    public void testGetByRoomNumberParseError() {
        when(sut.findByRoomNumber("0")).thenThrow(InvalidInputException.class);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByRoomNumberNotFound() {
        when(sut.findByRoomNumber("999999")).thenThrow(ResourceNotFoundException.class);
    }

    @Test
    public void testGetByMaxOccupancy() {
        when(repo.findByMaxOccupancy(testRooms.get(0).getMaxOccupancy())).thenReturn(Collections.singletonList(testRooms.get(0)));
        assertEquals(Collections.singletonList(testRooms.get(0)), sut.findByMaxOccupancy(testRooms.get(0).getMaxOccupancy()));
    }

//    @Test
//    public void testGetByResourceOwner() {
//        when(repo.findAll()).thenReturn(testRooms);
//        assertEquals(sut.findByResourceOwner(1), testRooms.get(0));
//    }

//    @Test
//    public void testUpdateRoom() {
//        when(repo.save(testRooms.get(0))).thenReturn(testRooms.get(1));
//        assertEquals(testRooms.get(1), sut.update(testRooms.get(0)));
//    }

}
