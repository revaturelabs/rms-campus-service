package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.services.CampusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CampusControllerTest {

    @InjectMocks
    private CampusController campusController;

    @Mock
    private CampusService campusService;

    @Test
    public void testFindAllCampusWithValidCampus() {
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        List<Campus> testCampusList = Arrays.asList(testCampus);

        when(campusService.findAll()).thenReturn(testCampusList);

        assertEquals(campusController.getAllCampus(), testCampusList);
    }

    @Test
    public void testFindAllCampusWithNoCampuses() {

        List<Campus> testListCampus = Collections.emptyList();

        when(campusService.findAll()).thenReturn(testListCampus);

        assertEquals(campusController.getAllCampus(), testListCampus);
    }

    @Test
    public void testSaveCampusWithValidCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());
        Campus persistedCampus = new Campus("32","University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(campusService.save(Mockito.any())).thenReturn(persistedCampus);

        assertEquals(campusController.saveCampus(testCampus), persistedCampus);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveCampusWithNullCampus() {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        Campus expectedResult = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());

        when(campusService.save(Mockito.any())).thenReturn(expectedResult);
        assertEquals(campusController.saveCampus(null), expectedResult);
    }
}
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(MockitoJUnitRunner.class)
//
//public class CampusControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @InjectMocks
//    private CampusService campusService;
//
//    @Test
//    public void testCampusWithCampusWillReturnJSONArray() throws Exception {
//        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
//                2, 3, 4, new Building[1], new int[3], new ResourceMetadata());
//
//        List<Campus> testListCampus = Arrays.asList(testCampus);
//        when(campusService.findAll()).thenReturn(testListCampus);
//
//        mvc.perform(MockMvcRequestBuilders.get("/v2/campus").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//}
