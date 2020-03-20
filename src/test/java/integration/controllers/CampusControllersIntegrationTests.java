package integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rms.campus.CampusServiceApplication;
import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Below are the integration tests for the CampusController class. The methods tested are:
 * - getAllCampus
 * - saveCampus
 * - getCampusById
 * - updateCampus
 * - deleteCampusById
 */
@SpringBootTest(classes = CampusServiceApplication.class)
@AutoConfigureMockMvc
public class CampusControllersIntegrationTests {

    @Autowired
    private MockMvc mvc;

    /**
     * The method below was created to transform the object passed into a string to satisfy the requirements of
     * MockMvcRequestBuilders methods.
     * @param obj
     * @return String
     */
    public static String asJSON(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This test ensures CampusController.getAllCampus() functions by performing a get method with the provided url. The
     * method expects the information received and returned is of the ApplicationJSON MediaType. If done successfully,
     * the method should have a status code of 200.
     * @throws Exception caused as a result of the mvc.perform()
     */
    @Test
    public void testGetAllCampusWithExistingCampusExpecting200() throws Exception {

        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());

        this.mvc.perform(get("/v2/campus").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * This test ensures CampusController.saveCampus() functions by performing a post method with the provided url and
     * the string representation of the testCampus object passed in. The method expects the information received and
     * returned is of the ApplicationJSON MediaType.
     *
     * Note this may need to be played with more - should technically be status 201, but changing the method signature
     * and logic to reflect this still has it producing 200
     * @throws Exception caused as a result of the mvc.perform()
     */
    @Test
    public void testSaveCampusWithValidCampusExpecting200() throws Exception {
        Campus testCampus = new Campus("University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());

        this.mvc.perform(post("/v2/campus").content(asJSON(testCampus)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * This test ensures CampusController.getCampusById() functions by performing a get method with the provided url
     * containing the provided value for the id. The method expects the information received and returned is of the
     * ApplicationJSON MediaType. The test also confirms the path contains the value of the Campus.id and this value is
     * equivalent to the provided. Additionally, performed a post to ensure there was an accurate object to retrive and
     * compare results to.
     * @throws Exception caused as a result of the mvc.perform()
     */
    @Test
    public void testGetCampusWithValidIdExpecting200() throws Exception {
        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());

        this.mvc.perform(post("/v2/campus").content(asJSON(testCampus)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
        this.mvc.perform(get("/v2/campus/{id}", "32").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(32));
    }

    /**
     * Test ensures CampusController.updateCampus() functions by performing a put method with a string representation of
     * the campus object converted to JSON. Expects a 200 status and the MediaTypes are JSON.
     * @throws Exception as a result of mvc.perform()
     */
    @Test
    public void testUpdateCampusWithValidCampusExpecting200() throws Exception {

        Campus testCampus = new Campus("32", "University of South Florida", "USF", new Address(),
                2, 3, 4, new ArrayList<Building>(1),
                new ArrayList<Integer>(3), new ResourceMetadata());

        this.mvc.perform(put("/v2/campus").content(asJSON(testCampus)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * Test ensures CampusController.deleteById() functions by performing a delete method with the provided URL
     * containing the id of the object to be deleted. Expects a 200 status and the MediaTypes are JSON.
     * @throws Exception as a result of mvc.perform()
     */
    @Test
    public void testDeleteCampusByIdWithValidIdExpecting200() throws Exception {

        this.mvc.perform(delete("/v2/campus/{id}", "32").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

}
