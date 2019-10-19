package Transport.Controller.DriverControllers;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.InternationalDriver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Factory.DriversFactories.InternationalDriverFactory;
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

public class InternationalDriverControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/InternationalDriver";

    @Test
    public void create()
    {

        Driver d1 = DriverFactory.getDriver("AR2161","BC3456", true);

        InternationalDriver driver = InternationalDriverFactory.getInternationalDriver("Samantha", "Lorris", "09/02/1997", true,d1 );

        ResponseEntity<InternationalDriver> postResponse = restTemplate.postForEntity(baseURL + "/create", driver, InternationalDriver.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        InternationalDriver driver = restTemplate.getForObject(baseURL + "/InternationalDriver/" + id, InternationalDriver.class);

        restTemplate.put(baseURL + "/internationalDrivers/" + id, driver);
        InternationalDriver updatedDriver = restTemplate.getForObject(baseURL + "/InternationalDriver/" + id, InternationalDriver.class);
        Assert.assertNotNull(updatedDriver);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        InternationalDriver driver = restTemplate.getForObject(baseURL + "/InternationalDriver/" + id, InternationalDriver.class);
        Assert.assertNotNull(driver);
        restTemplate.delete(baseURL + "/InternationalDriver/" + id);

        try
        {
            driver = restTemplate.getForObject(baseURL + "/InternationalDriver/" + id, InternationalDriver.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        InternationalDriver driver = restTemplate.getForObject(baseURL + "/InternationalDriver/1", InternationalDriver.class);
        System.out.println(driver.getDrive().getDriverID());
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