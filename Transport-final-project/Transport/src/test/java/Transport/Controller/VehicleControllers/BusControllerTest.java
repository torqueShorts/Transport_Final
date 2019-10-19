package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Bus;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.BusFactory;
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

public class BusControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/bus";


    @Test
    public void create()
    {
        Vehicle veh1 = VehicleFactory.getVehicle("AC74385", "Bus", "081489359");

        Bus bus = BusFactory.getBus("Blue","Golden Arrow", veh1);

        ResponseEntity<Bus> postResponse = restTemplate.postForEntity(baseURL + "/create", bus, Bus.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Bus bus = restTemplate.getForObject(baseURL + "/bus/" + id, Bus.class);

        restTemplate.put(baseURL + "/bus/" + id, bus);
        Bus updatedBus= restTemplate.getForObject(baseURL + "/Bus/" + id, Bus.class);
        Assert.assertNotNull(updatedBus);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Bus bus = restTemplate.getForObject(baseURL + "/bus/" + id, Bus.class);
        Assert.assertNotNull(bus);
        restTemplate.delete(baseURL + "/bus/" + id);

        try
        {
            bus = restTemplate.getForObject(baseURL + "/bus/" + id, Bus.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Bus bus = restTemplate.getForObject(baseURL + "/bus/1", Bus.class);
        System.out.println(bus.getVeh().getVehicleLicense());
        Assert.assertNotNull(bus);
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