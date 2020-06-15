//package com.revature.rms.campus.controllers;
//
//import com.revature.rms.campus.entities.ResourceMetadata;
//import com.revature.rms.campus.entities.Room;
//import com.revature.rms.campus.entities.RoomStatus;
//import com.revature.rms.campus.exceptions.InvalidInputException;
//import com.revature.rms.campus.exceptions.ResourceNotFoundException;
//import com.revature.rms.campus.services.RoomService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.*;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class RoomControllerTest {
//
//    @InjectMocks
//    private RoomController roomController;
//
//    @Mock
//    private RoomService roomService;
//
//    @Test
//    public void testFindAllRoomsWithValidRoom(){
//        Room testRoom = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//
//        List<Room> testRoomList = Arrays.asList(testRoom);
//
//        when(roomService.findAll()).thenReturn(testRoomList);
//
//        assertEquals(roomController.getAllRooms(), testRoomList);
//    }
//
//    @Test
//    public void testFindAllRoomWithNoRoom(){
//        List<Room> testRoomList = Collections.emptyList();
//        when(roomService.findAll()).thenReturn(testRoomList);
//        assertEquals(roomController.getAllRooms(), testRoomList);
//    }
//
//    @Test
//    public void testSaveRoomWithValidRoom(){
//        Room testRoom = new Room("2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//        Room persistedRoom = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//
//        when(roomService.save(Mockito.any())).thenReturn(persistedRoom);
//
//        assertEquals(roomController.saveRoom(testRoom),persistedRoom);
//    }
//
//    @Test(expected = ResourceNotFoundException.class)
//    public void testSaveRoomWithNullRoom(){
//        Room testRoom = new Room("2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//        Room persistedRoom = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//
//        when(roomService.save(Mockito.any())).thenReturn(persistedRoom);
//
//        assertEquals(roomController.saveRoom(null),persistedRoom);
//    }
//
//    @Test
//    public void testGetRoomByValidId() {
//        String id = "1";
//        Room expectedResult = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//        when(roomService.findById(Mockito.any())).thenReturn(Optional.of(expectedResult));
//        assertEquals(roomController.getRoomById(id), expectedResult);
//    }
//
//    @Test(expected = ResourceNotFoundException.class)
//    public void testGetRoomByIdNotFound(){
//        String id = "32";
//        when(roomService.findById(Mockito.any())).thenReturn(Optional.empty());
//        roomController.getRoomById(id);
//    }
//
//    @Test(expected = InvalidInputException.class)
//    public void testGetRoomWithInvalidRoom(){
//        String id = "";
//        when(roomService.findById(Mockito.any())).thenReturn(null);
//        assertEquals(roomController.getRoomById(id), null);
//    }
//
//    @Test
//    public void testUpdateRoomWithRoom(){
//        Room testRoom = new Room("2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//        Room expectedResult = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//
//        when(roomService.update(Mockito.any())).thenReturn(expectedResult);
//        assertEquals(roomController.updateRoom(testRoom), expectedResult);
//    }
//
//    @Test
//    public void testDeleteRoomWithValidId(){
//        Room testRoom = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//
//        when(roomService.findById(Mockito.any())).thenReturn(Optional.of(testRoom));
//        roomController.deleteRoomById(testRoom.getId());
//        verify(roomService, times(1)).delete(testRoom.getId());
//    }
//
//    @Test(expected = InvalidInputException.class)
//    public void testDeleteRoomWithInvalidId(){
//        Room testRoom = new Room("1", "2301", 25, true, new ArrayList<RoomStatus>(5),
//                "1612", new ArrayList<String>(3), new ResourceMetadata());
//
//        String id = "-1";
//        when(roomService.findById(Mockito.any())).thenReturn(Optional.of(testRoom));
//        roomController.deleteRoomById(id);
//        verify(roomService, times(0)).delete(id);
//
//    }
//}
