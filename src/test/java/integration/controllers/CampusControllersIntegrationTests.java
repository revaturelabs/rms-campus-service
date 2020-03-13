package integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rms.campus.CampusServiceApplication;
import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest(classes = CampusServiceApplication.class)
@AutoConfigureMockMvc
public class CampusControllersIntegrationTests {

    @Autowired
    private MockMvc mvc;

    public static String asJSON(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetAllCampusWithExistingCampusExpecting200() throws Exception {

        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());

        this.mvc.perform(get("/v2/campus").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testSaveCampusWithValidCampusExpecting200() throws Exception {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());


        this.mvc.perform(post("/v2/campus").content(asJSON(testCampus)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetCampusWithValidIdExpecting200() throws Exception {
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());

        this.mvc.perform(get("/v2/campus/{id}", 32).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(32));
    }

//    @LocalServerPort
//    private int port;
//
//    TestRestTemplate rt = new TestRestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//
//    private String creatingURL(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//
//    @Test
//    public void testGetAllCampus() {
//        ResponseEntity<List<Campus>> response = rt.exchange(creatingURL("/v2/campus"), HttpMethod.GET,
//                new HttpEntity<String>("Dummy", headers), new ParameterizedTypeReference<List<Campus>>() {});
//
//        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
//                2, 3, 4, new ArrayList<Building>(1),
//                new ArrayList<Integer>(3), new ResourceMetadata());
//
//        assertTrue(response.getBody().contains(testCampus));
//    }
}
