package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.entities.RoomStatus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
//import com.revature.rms.campus.repositories.RoomMongoRepository;
import com.revature.rms.campus.repositories.RoomRepository;
//import com.revature.rms.campus.repositories.RoomStatusMongoRepository;
import com.revature.rms.campus.repositories.RoomStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
//    private RoomMongoRepository roomMongoRepository;
    private RoomRepository roomRepository;

    @Autowired
//    private RoomStatusMongoRepository roomStatusRepo;
    private RoomStatusRepository roomStatusRepo;

    /**
     * findAll method: returns a list of all the room objects in the database.
     * @return a list of all the rooms
     */
//    public List<Room> findAll(){ return roomMongoRepository.findAll();
    @Transactional(readOnly = true)
    public List<Room> findAll(){
            Iterable<Room> r = roomRepository.findAll();
            List<Room> list = getListFromIterator(r);
            return list;
    }

    /**
     * findByRoomNumber Method: This takes in the room number as the input
     * parameter. The input room number is validated to ensure that it is not
     * empty or negative or zero. If the room number fails this validation an
     * InvalidInputException is thrown.
     * The room object with the specified room number is retrieved. The room
     * object is tested to ensure that the room object is present. If the room
     * object is not present then a ResourceNotFoundException is thrown.
     * If all these validations are passed, the room object that have the specified
     * room number is returned.
     * @param roomNum
     * @return the room object with the same room number as the input parameter.
     */
    @Transactional(readOnly = true)
    public Optional<Room> findByRoomNumber(String roomNum){
        if (roomNum.isEmpty() || (Integer.parseInt(roomNum) <= 0)) {
            throw new InvalidInputException();
        }
//        Optional<Room> _room = roomMongoRepository.findByRoomNumber(roomNum);
        Optional<Room> _room = roomRepository.findByRoomNumber(roomNum);

        if(!_room.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return _room;
    }

    /**
     * findById Method: This takes in the room id parameter. The room
     * id is unique in the system, that is no two rooms can have the
     * same id. The id is validated to ensure that it is not empty or
     * negative or zero. If the id fails this validation an
     * InvalidInputException is thrown.
     *
     * Next, the room object is found using the id. If the returned
     * object is not present, a ResourceNotFoundException is thrown.
     * However, if it passes all these checks the room object with
     * the id equal to the given id is returned.
     * @param id
     * @return The specific room with the given id
     */
    @Transactional(readOnly = true)
    public Optional<Room> findById(int id){
//        if (id.isEmpty() || (Integer.parseInt(id) <= 0)) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
//        Optional<Room> _room = roomMongoRepository.findById(id);
        Optional<Room> _room = roomRepository.findById(id);
        if(!_room.isPresent()){
            throw new ResourceNotFoundException();
        }
        return _room;
    }

    /**
     * findAllActiveRooms Method: This takes in the active parameter,
     * that is, true or false. This allows us to get a list of all
     * active rooms if true is passed in or a list of all the inactive
     * rooms if false is passed in.
     * @param active
     * @return a list of all the active or available rooms

    public List<Room> findAllActiveRooms(boolean active){
        return roomMongoRepository.findByActiveRooms(active);
    }
    */

    /**
     * findByMaxOccupancy Method: This takes in the required or specified
     * occupancy that we are searching for and returns a list of all the
     * rooms that have that same occupancy.
     * @param occupancy
     * @return a list of all the rooms with the specified occupancy.
     */
    @Transactional(readOnly = true)
    public List<Room> findByMaxOccupancy(int occupancy){
//        return roomMongoRepository.findByMaxOccupancy(occupancy);
        return roomRepository.findByMaxOccupancy(occupancy);
    }

    /**
     * Save Method: Takes in a room object as the input. The input room
     * object is tested to ensure that it is not null. If the room object
     * is null then it will throw a ResourceNotFoundException.
     * Once the room object passes the test it is then saved or persisted
     * to the database.
     * @param room
     * @return The new saved room object
     */
    @Transactional
    public Room save(Room room){
        if(room == null){
            throw new ResourceNotFoundException();
        }
//        return roomMongoRepository.save(room);
        return roomRepository.save(room);
    }

    /**
     * Update Method: The room object is inputted and changes are saved.
     * The modified object is returned.
     * @param room
     * @return Updated/Modified room object
     */
//    public Room update(Room room){return roomMongoRepository.save(room);}
    @Transactional
    public Room update(Room room){return roomRepository.save(room);}

    /**
     * Soft Delete Method: Updates the room object by setting active to
     * false (to indicate the room is no longer in use). Soft delete is
     * implemented to achieve data in the event of auditing. Soft delete
     * may need some modifications to pass all tests.
     *
     * The method takes in the room id. The input is tested to ensure
     * that it is not empty, negative or zero. if the input is empty,
     * negative or zero, an InvalidInputException is thrown.
     *
     * The room id is used to retrieve the specific room object. The
     * active parameter of the retrieved room object is set to false
     * and the room object is then saved or updated.
     * @param id
     * @return The Updated room objected.
     */
    @Transactional
    public Room delete(int id){
//        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
//        Room deleteRoom = roomMongoRepository.findById(id).get();
        Room deleteRoom = roomRepository.findById(id).get();
        deleteRoom.setActive(false);
        return update(deleteRoom);
    }

    /**
     * findAllStatusBySubmitter Method: The submitter id is inputted as
     * the search criteria. A list of room status objects that have the
     * same submitter id as the given parameter will be returned.
     * Allows us, to easily compile a list of room statuses that were
     * submitted by a specific user.
     * @param id
     * @return the list of room status objects submitted by the given user id.
     */
    @Transactional(readOnly = true)
    public List<RoomStatus> findAllStatusBySubmitter(int id){
        return roomStatusRepo.findAllBySubmitterId(id);
    }

    /**
     * findAllStatusByDate Method: A date of type String is passed into the method.
     * The given date is then used to find all room status objects that have the same
     * date as there submitted date parameter.
     * Allows us, to easily compile a list of room statuses that were submitted on a
     * particular date.
     * @param date
     * @return the list of room status objects with the specified submitted date
     */
    @Transactional(readOnly = true)
    public List<RoomStatus> findAllStatusByDate(String date){ return roomStatusRepo.findAllBySubmittedDateTime(date);}

    /**
     * findByStatusId Method: This takes in the status id parameter. The status id
     * is unique in the system, that is no two room statuses can have the same id.
     *
     * Next, the room status object is found using the status id, that is the room
     * status that have the same status id is returned.
     * @param id
     * @return the room status with the given status id.
     */
    @Transactional(readOnly = true)
    public Optional<RoomStatus> findStatusById(int id){
        return roomStatusRepo.findById(id);
    }

    /**
     * findAll Method: This method returns a list of all the room status objects
     * in the database.
     * @return a list of all the room status objects
     */
    @Transactional(readOnly = true)
    public List<RoomStatus> findAllStatus(){
        Iterable<RoomStatus> r = roomStatusRepo.findAll();
        List<RoomStatus> list = getListFromIterator(r);
        return list;
//        return roomStatusRepo.findAll();
    }

    /**
     * findAllByArchive Method: This method takes in the boolean active parameter.
     * The method will return a list of all the active room status objects if
     * the input active is false. However, the method will return a list of all
     * the inactive or archived room statuses if the input is false.
     * @param active
     * @return a list of all the room status objects that are active or inactive.
     */
    @Transactional(readOnly = true)
    public List<RoomStatus> findAllByArchive(boolean active){

        return roomStatusRepo.findAllByArchived(active);
    }

    /**
     * saveStatus Method: This method takes in a new room status object and
     * saves it to the database.
     * @param roomStatus
     */
    @Transactional
    public void saveStatus(RoomStatus roomStatus){
        roomStatusRepo.save(roomStatus);
    }


    /**
     * Update Method: The room status object is inputted and changes are saved.
     * The modified object is returned.
     * @param roomStatus
     * @return Updated/Modified room status object
     */
    @Transactional
    public RoomStatus updateStatus(RoomStatus roomStatus){
        return roomStatusRepo.save(roomStatus);
    }

    /**
     * Soft Delete Method: Similar to the room soft delete method. Updates
     * the room status object by setting archived to true (to indicate the
     * room status is no longer in use or archived). Soft delete is
     * implemented to achieve data in the event of auditing. Soft delete
     * may need some modifications to pass all tests.
     *
     * The method takes in and uses the room status id to retrieve the
     * specific room status object. The archived parameter of the retrieved
     * room status object is set to true and the room status object is saved
     * or updated.
     * @param statusId
     * @return The Updated room status objected.
     */
    @Transactional
    public void deleteRoomStatus(int statusId){
        RoomStatus deleteStatus = roomStatusRepo.findById(statusId).get();
        deleteStatus.setArchived(true);
        saveStatus(deleteStatus);
    }

    //added to convert to h2
    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
