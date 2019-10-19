package Transport.Controller.DepartmentControllers;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Factory.DepartmentFactoryTests.TrafficDepartmentFactory;
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

public class TrafficDepartmentControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/TrafficDepartment";

    @Test
    public void create()
    {
        TrafficDepartment trafficDepartment = TrafficDepartmentFactory.getTrafficDepartment("57 Adeline street", "DP2938");

        ResponseEntity<TrafficDepartment> postResponse = restTemplate.postForEntity(baseURL + "/create", trafficDepartment, TrafficDepartment.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        TrafficDepartment trafficDepartment = restTemplate.getForObject(baseURL + "/TrafficDepartment/" + id, TrafficDepartment.class);

        restTemplate.put(baseURL + "/TrafficDepartment/" + id, trafficDepartment);
        TrafficDepartment updatedDepartment = restTemplate.getForObject(baseURL + "/TrafficDepartment/" + id, TrafficDepartment.class);
        Assert.assertNotNull(updatedDepartment);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        TrafficDepartment trafficDepartment = restTemplate.getForObject(baseURL + "/TrafficDepartment/" + id, TrafficDepartment.class);
        Assert.assertNotNull(trafficDepartment);
        restTemplate.delete(baseURL + "/TrafficDepartment/" + id);

        try
        {
            trafficDepartment = restTemplate.getForObject(baseURL + "/TrafficDepartment/" + id, TrafficDepartment.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        TrafficDepartment trafficDepartment = restTemplate.getForObject(baseURL + "/TrafficDepartment/1", TrafficDepartment.class);
        System.out.println(trafficDepartment.getDeptCode());
        Assert.assertNotNull(trafficDepartment);
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