package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.HeavyDutyFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
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

public class HeavyDutyControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/heavyDuty";

    @Test
    public void create()
    {
        Vehicle veh1 = VehicleFactory.getVehicle("AC74385", "Bus", "081489359");

        HeavyDuty heavyDuty = HeavyDutyFactory.getHeavyDuty("Blue","Golden Arrow", veh1);

        ResponseEntity<HeavyDuty> postResponse = restTemplate.postForEntity(baseURL + "/create", heavyDuty, HeavyDuty.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        HeavyDuty heavyDuty = restTemplate.getForObject(baseURL + "/heavyDuty/" + id, HeavyDuty.class);

        restTemplate.put(baseURL + "/heavyDuty/" + id, heavyDuty);
        HeavyDuty updatedHeavyDuty = restTemplate.getForObject(baseURL + "/HeavyDuty/" + id, HeavyDuty.class);
        Assert.assertNotNull(updatedHeavyDuty);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        HeavyDuty heavyDuty = restTemplate.getForObject(baseURL + "/heavyDuty/" + id, HeavyDuty.class);
        Assert.assertNotNull(heavyDuty);
        restTemplate.delete(baseURL + "/heavyDuty/" + id);

        try
        {
            heavyDuty = restTemplate.getForObject(baseURL + "/heavyDuty/" + id, HeavyDuty.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        HeavyDuty heavyDuty = restTemplate.getForObject(baseURL + "/heavyDuty/1", HeavyDuty.class);
        System.out.println(heavyDuty.getVeh().getVehicleLicense());
        Assert.assertNotNull(heavyDuty);
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