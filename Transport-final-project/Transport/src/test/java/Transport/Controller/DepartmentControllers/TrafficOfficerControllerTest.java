package Transport.Controller.DepartmentControllers;

import Transport.Domain.Department.TrafficOfficer;
import Transport.Factory.DepartmentFactoryTests.TrafficOfficerFactory;
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

public class TrafficOfficerControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/TrafficOfficer";

    @Test
    public void create()
    {
        TrafficOfficer trafficOfficer = TrafficOfficerFactory.getOfficer("AR2334","John", "Bonny", "RD2345", "JID2345");

        ResponseEntity<TrafficOfficer> postResponse = restTemplate.postForEntity(baseURL + "/create", trafficOfficer, TrafficOfficer.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        TrafficOfficer trafficOfficer = restTemplate.getForObject(baseURL + "/TrafficOfficer/" + id, TrafficOfficer.class);

        restTemplate.put(baseURL + "/TrafficOfficer/" + id, trafficOfficer);
        TrafficOfficer updatedOfficer = restTemplate.getForObject(baseURL + "/TrafficOfficer/" + id, TrafficOfficer.class);
        Assert.assertNotNull(updatedOfficer);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        TrafficOfficer trafficOfficer = restTemplate.getForObject(baseURL + "/TrafficOfficer/" + id, TrafficOfficer.class);
        Assert.assertNotNull(trafficOfficer);
        restTemplate.delete(baseURL + "/TrafficOfficer/" + id);

        try
        {
            trafficOfficer = restTemplate.getForObject(baseURL + "/TrafficOfficer/" + id, TrafficOfficer.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        TrafficOfficer trafficOfficer = restTemplate.getForObject(baseURL + "/TrafficOfficer/1", TrafficOfficer.class);
        System.out.println(trafficOfficer.getOfficerID());
        Assert.assertNotNull(trafficOfficer);
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