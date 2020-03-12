//package integration.controllers;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CampusControllersIntegrationTests {
//
//    @LocalServerPort
//    private int port;
//
//    TestRestTemplate rt = new TestRestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//
//    @Test
//    public void testGetAllCampus() {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = rt.exchange(createURLWithPort("/v2/campus"))
//    }
//}
