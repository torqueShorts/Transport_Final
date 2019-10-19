package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.MotobikeFactory;
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

public class MotorbikeControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/motorbike";

    @Test
    public void create()
    {
        Vehicle veh1 = VehicleFactory.getVehicle("AC74385", "Bus", "081489359");

        Motorbike motorbike = MotobikeFactory.getMotorbike("Blue","Golden Arrow", veh1);

        ResponseEntity<Motorbike> postResponse = restTemplate.postForEntity(baseURL + "/create", motorbike, Motorbike.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());

    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Motorbike motorbike = restTemplate.getForObject(baseURL + "/motorbike/" + id, Motorbike.class);

        restTemplate.put(baseURL + "/motorbike/" + id, motorbike);
        Motorbike updatedMotorbike = restTemplate.getForObject(baseURL + "/Motorbike/" + id, Motorbike.class);
        Assert.assertNotNull(updatedMotorbike);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Motorbike motorbike = restTemplate.getForObject(baseURL + "/motorbike/" + id, Motorbike.class);
        Assert.assertNotNull(motorbike);
        restTemplate.delete(baseURL + "/motorbike/" + id);

        try
        {
            motorbike = restTemplate.getForObject(baseURL + "/motorbike/" + id, Motorbike.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Motorbike motorbike = restTemplate.getForObject(baseURL + "/motorbike/1", Motorbike.class);
        System.out.println(motorbike.getVeh().getVehicleLicense());
        Assert.assertNotNull(motorbike);
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