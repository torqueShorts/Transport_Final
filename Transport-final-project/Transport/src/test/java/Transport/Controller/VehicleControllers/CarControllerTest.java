package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Car;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.CarFactory;
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

public class CarControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/car";

    @Test
    public void create()
    {
        Vehicle veh1 = VehicleFactory.getVehicle("AC74385", "Bus", "081489359");

        Car car = CarFactory.getCar("Blue","Golden Arrow", veh1);

        ResponseEntity<Car> postResponse = restTemplate.postForEntity(baseURL + "/create", car, Car.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Car car = restTemplate.getForObject(baseURL + "/car/" + id, Car.class);

        restTemplate.put(baseURL + "/car/" + id, car);
        Car updatedCar = restTemplate.getForObject(baseURL + "/Car/" + id, Car.class);
        Assert.assertNotNull(updatedCar);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Car car = restTemplate.getForObject(baseURL + "/car/" + id, Car.class);
        Assert.assertNotNull(car);
        restTemplate.delete(baseURL + "/car/" + id);

        try
        {
            car = restTemplate.getForObject(baseURL + "/car/" + id, Car.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Car car = restTemplate.getForObject(baseURL + "/car/1", Car.class);
        System.out.println(car.getVeh().getVehicleLicense());
        Assert.assertNotNull(car);
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