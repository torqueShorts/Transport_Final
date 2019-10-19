package Transport.Controller.DriverControllers;

import Transport.Domain.Drivers.Driver;
import Transport.Factory.DriversFactories.DriverFactory;
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

public class DriverControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Driver";

    @Test
    public void create()
    {
        Driver driver = DriverFactory.getDriver("081475354", "AC7465993", true);

        ResponseEntity<Driver> postResponse = restTemplate.postForEntity(baseURL + "/create", driver, Driver.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Driver driver = restTemplate.getForObject(baseURL + "/Driver/" + id, Driver.class);

        restTemplate.put(baseURL + "/drivers/" + id, driver);
        Driver updatedDriver = restTemplate.getForObject(baseURL + "/Driver/" + id, Driver.class);
        Assert.assertNotNull(updatedDriver);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Driver driver = restTemplate.getForObject(baseURL + "/Driver/" + id, Driver.class);
        Assert.assertNotNull(driver);
        restTemplate.delete(baseURL + "/Driver/" + id);

        try
        {
            driver = restTemplate.getForObject(baseURL + "/Driver/" + id, Driver.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Driver driver = restTemplate.getForObject(baseURL + "/Driver/1", Driver.class);
        System.out.println(driver.getDriverID());
        Assert.assertNotNull(driver);
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