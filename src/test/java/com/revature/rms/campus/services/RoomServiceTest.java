package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.entities.RoomStatus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.repositories.RoomMongoRepository;
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
    RoomMongoRepository repo;

    @InjectMocks
    RoomService sut;


    @Test
    public void testSaveWithValidRoom(){
        //Arrange
        Room testRoom = new Room("BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        Room expectedResult = new Room("1", "BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(expectedResult);

        //Act
        Room actualResults = sut.save(testRoom);

        //Assert
        assertEquals(actualResults, expectedResult);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveWithNullRoom(){
        //Arrange
        Room testRoom = new Room("BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        Room expectedResult = new Room("1", "BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(expectedResult);

        //Act
        Room actualResults = sut.save(null);

        //Assert
        assertEquals(actualResults, expectedResult);
    }

    @Test
    public void testFindAll(){
        Room testRoom = new Room("BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        List<Room> mockRoomList = new ArrayList<>();
        when(repo.findAll()).thenReturn(mockRoomList);
        assertEquals(mockRoomList, sut.findAll());
    }

    @Test
    public void testFindAllRoomWithNoRoom(){
        List<Room> mockRoomList = Collections.emptyList();
        when(repo.findAll()).thenReturn(mockRoomList);
        assertEquals(mockRoomList, sut.findAll());
    }

    @Test
    public void testFindByRoomNumberWithValidRoomNumber(){
        Optional<Room> expectedResult = Optional.of(new Room("23", "BSN 2304", 35, true, new ArrayList<RoomStatus>(5),
                1912, new ArrayList<Integer>(2), new ResourceMetadata()));

        when(repo.findByRoomNumber(Mockito.any())).thenReturn(expectedResult);
        Optional<Room> actualResult = sut.findByRoomNumber("BSN 2304");
        assertEquals(actualResult, expectedResult);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testFindByRoomNumberWithValidNotFound(){
        when(repo.findByRoomNumber(Mockito.any())).thenReturn(Optional.empty());
        sut.findByRoomNumber("65");
    }

    @Test
    public void testFindByIdWithValidId(){
        Optional<Room> expectedResult = Optional.of(new Room("23", "BSN 2304", 35, true, new ArrayList<RoomStatus>(5),
                1912, new ArrayList<Integer>(2), new ResourceMetadata()));

        when(repo.findById(Mockito.any())).thenReturn(expectedResult);
        Optional<Room> actualResult = sut.findById("23");
        assertEquals(actualResult, expectedResult);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testFindByIdWithValidIdNotFound(){
     when(repo.findById(Mockito.any())).thenReturn(Optional.empty());
     sut.findById("36");
    }

    @Test(expected = InvalidInputException.class)
    public void testFindByIdWithInvalidId(){
        sut.findById(""); sut.findById("0");
        verify(repo.findById("0"), times(0));
    }

    @Test
    public void testFindAllActiveRooms(){
        Room testRoom = new Room("BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        List<Room> activeRoomList = new ArrayList<>();
        when(repo.findByActiveRooms(Mockito.anyBoolean())).thenReturn(activeRoomList);
        assertEquals(activeRoomList, sut.findAllActiveRooms(true));
    }

    @Test
    public void testFindAllInActiveRooms(){
        Room testRoom = new Room("ENG 2319", 35, false, new ArrayList<RoomStatus>(5),
                2319, new ArrayList<Integer>(3), new ResourceMetadata());

        List<Room> activeRoomList = new ArrayList<>();
        when(repo.findByActiveRooms(Mockito.anyBoolean())).thenReturn(activeRoomList);
        assertEquals(activeRoomList, sut.findAllActiveRooms(false));
    }

    @Test
    public void testFindMaxOccupancyRooms(){
        Room testRoom = new Room("MAT 2401", 35, true, new ArrayList<RoomStatus>(5),
                2401, new ArrayList<Integer>(3), new ResourceMetadata());

        List<Room> occupancyRoomList = new ArrayList<>();
        when(repo.findByActiveRooms(Mockito.any())).thenReturn(occupancyRoomList);
        assertEquals(occupancyRoomList, sut.findByMaxOccupancy(35));
    }

    @Test
    public void testUpdateWithValidRoom(){
        Room testRoom = new Room("32", "mocked", 40, true, new ArrayList<RoomStatus>(5),
                3232, new ArrayList<Integer>(3), new ResourceMetadata());

        Room expectedResult = new Room("32", "mocked", 40, true, new ArrayList<RoomStatus>(5),
                3232, new ArrayList<Integer>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(expectedResult);
        Room actualResults = sut.update(testRoom);
        assertEquals(actualResults, expectedResult);
    }

    @Test
    public void testDeleteWithValidId(){
        Room testRoom = new Room("BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(Optional.of(testRoom));
        sut.delete(testRoom.getId());
        verify(repo, times(1)).deleteById(testRoom.getId());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteWithInValidId(){
        Room testRoom = new Room("BSN 2301", 25, true, new ArrayList<RoomStatus>(5),
                1612, new ArrayList<Integer>(3), new ResourceMetadata());

        when(repo.save(Mockito.any())).thenReturn(Optional.of(testRoom));
        sut.delete("-1");
        verify(repo, times(1)).deleteById("-1");
    }

}
