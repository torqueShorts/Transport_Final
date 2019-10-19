package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Taxi;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.TaxiFactory;
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

public class TaxiControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/taxi";

    @Test
    public void create()
    {
        Vehicle veh1 = VehicleFactory.getVehicle("AC74385", "Bus", "081489359");

        Taxi taxi = TaxiFactory.getTaxi("Blue","Golden Arrow", veh1);

        ResponseEntity<Taxi> postResponse = restTemplate.postForEntity(baseURL + "/create", taxi, Taxi.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Taxi taxi = restTemplate.getForObject(baseURL + "/motorbike/" + id, Taxi.class);

        restTemplate.put(baseURL + "/taxi/" + id, taxi);
        Taxi updatedTaxi = restTemplate.getForObject(baseURL + "/Taxi/" + id, Taxi.class);
        Assert.assertNotNull(updatedTaxi);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Taxi taxi = restTemplate.getForObject(baseURL + "/taxi/" + id, Taxi.class);
        Assert.assertNotNull(taxi);
        restTemplate.delete(baseURL + "/taxi/" + id);

        try
        {
            taxi = restTemplate.getForObject(baseURL + "/taxi/" + id, Taxi.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Taxi taxi = restTemplate.getForObject(baseURL + "/taxi/1", Taxi.class);
        System.out.println(taxi.getVeh().getVehicleLicense());
        Assert.assertNotNull(taxi);
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