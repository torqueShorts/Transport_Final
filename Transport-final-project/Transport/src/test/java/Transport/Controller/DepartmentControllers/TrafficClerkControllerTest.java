package Transport.Controller.DepartmentControllers;


import Transport.Domain.Department.TrafficClerk;
import Transport.Factory.DepartmentFactoryTests.TrafficClerkFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class TrafficClerkControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/TrafficClerk";

    @Test
    public void create()
    {
        TrafficClerk trafficClerk = TrafficClerkFactory.getTrafficClerk("AR2334","John", "Bonny", "RD2345", false);

        ResponseEntity<TrafficClerk> postResponse = restTemplate.postForEntity(baseURL + "/create", trafficClerk, TrafficClerk.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        TrafficClerk trafficClerk = restTemplate.getForObject(baseURL + "/TrafficClerk/" + id, TrafficClerk.class);

        restTemplate.put(baseURL + "/TrafficClerk/" + id, trafficClerk);
        TrafficClerk updatedClerk = restTemplate.getForObject(baseURL + "/TrafficClerk/" + id, TrafficClerk.class);
        Assert.assertNotNull(updatedClerk);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        TrafficClerk trafficClerk = restTemplate.getForObject(baseURL + "/TrafficClerk/" + id, TrafficClerk.class);
        Assert.assertNotNull(trafficClerk);
        restTemplate.delete(baseURL + "/TrafficClerk/" + id);

        try
        {
            trafficClerk = restTemplate.getForObject(baseURL + "/TrafficChief/" + id, TrafficClerk.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void read()
    {
        TrafficClerk trafficClerk = restTemplate.getForObject(baseURL + "/TrafficClerk/1", TrafficClerk.class);
        System.out.println(trafficClerk.getClerkID());
        Assert.assertNotNull(trafficClerk);
    }

    @Test
    public void getAll()
    {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }
}