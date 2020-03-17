package com.revature.rms.campus.services;

import com.revature.rms.campus.repositories.RoomMongoRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {

    @Mock
    RoomMongoRepository repo;

    @InjectMocks
    RoomService sut;


    

}
