package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Vehicle;
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

public class VehicleControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/vehicle";

    @Test
    public void create()
    {
        Vehicle vehicle = VehicleFactory.getVehicle("AC74385", "Bus", "081489359");

        ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(baseURL + "/create", vehicle, Vehicle.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());

    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Vehicle vehicle = restTemplate.getForObject(baseURL + "/vehicle/" + id, Vehicle.class);

        restTemplate.put(baseURL + "/vehicle/" + id, vehicle);
        Vehicle updatedVehicle = restTemplate.getForObject(baseURL + "/Vehicle/" + id, Vehicle.class);
        Assert.assertNotNull(updatedVehicle);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Vehicle vehicle = restTemplate.getForObject(baseURL + "/vehicle/" + id, Vehicle.class);
        Assert.assertNotNull(vehicle);
        restTemplate.delete(baseURL + "/vehicle/" + id);

        try
        {
            vehicle = restTemplate.getForObject(baseURL + "/vehicle/" + id, Vehicle.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Vehicle vehicle = restTemplate.getForObject(baseURL + "/vehicle/1", Vehicle.class);
        System.out.println(vehicle.getVehicleLicense());
        Assert.assertNotNull(vehicle);
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