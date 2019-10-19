package Transport.Controller.DepartmentControllers;

import Transport.Domain.Department.TrafficChief;
import Transport.Factory.DepartmentFactoryTests.TraffiChiefFactory;
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

public class TrafficChiefControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/TrafficChief";


    @Test
    public void create()
    {
        TrafficChief trafficChief = TraffiChiefFactory.getTrafficChief("RD2345", "Denny", "Lenny", "RA2345");

        ResponseEntity<TrafficChief> postResponse = restTemplate.postForEntity(baseURL + "/create", trafficChief, TrafficChief.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());

    }

    @Test
    public void update()
    {
        String id = "AD5467";

        TrafficChief trafficChief = restTemplate.getForObject(baseURL + "/TrafficChief/" + id, TrafficChief.class);

        restTemplate.put(baseURL + "/TrafficChief/" + id, trafficChief);
        TrafficChief updatedChief = restTemplate.getForObject(baseURL + "/TrafficChief/" + id, TrafficChief.class);
        Assert.assertNotNull(updatedChief);

    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        TrafficChief trafficChief = restTemplate.getForObject(baseURL + "/TrafficChief/" + id, TrafficChief.class);
        Assert.assertNotNull(trafficChief);
        restTemplate.delete(baseURL + "/TrafficChief/" + id);

        try
        {
            trafficChief = restTemplate.getForObject(baseURL + "/TrafficChief/" + id, TrafficChief.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }


    }

    @Test
    public void read()
    {
        TrafficChief trafficChief = restTemplate.getForObject(baseURL + "/TrafficChief/1", TrafficChief.class);
        System.out.println(trafficChief.getChiefID());
        Assert.assertNotNull(trafficChief);
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