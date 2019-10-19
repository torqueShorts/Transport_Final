package Transport.Controller.DriverControllers;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.NationalDriver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Factory.DriversFactories.NationalDriverFactory;
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

public class NationalDriverControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/NationalDriver";

    @Test
    public void create()
    {
        Driver d1 = DriverFactory.getDriver("AR2161","BC3456", true);

        NationalDriver driver = NationalDriverFactory.getNationalDriver("Samantha", "Lorris", "09/02/1997",d1 );

        ResponseEntity<NationalDriver> postResponse = restTemplate.postForEntity(baseURL + "/create", driver, NationalDriver.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        NationalDriver driver = restTemplate.getForObject(baseURL + "/NationalDriver/" + id, NationalDriver.class);

        restTemplate.put(baseURL + "/nationalDrivers/" + id, driver);
        NationalDriver updatedDriver = restTemplate.getForObject(baseURL + "/NationalDriver/" + id, NationalDriver.class);
        Assert.assertNotNull(updatedDriver);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        NationalDriver driver = restTemplate.getForObject(baseURL + "/NationalDriver/" + id, NationalDriver.class);
        Assert.assertNotNull(driver);
        restTemplate.delete(baseURL + "/NationalDriver/" + id);

        try
        {
            driver = restTemplate.getForObject(baseURL + "/NationalDriver/" + id, NationalDriver.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        NationalDriver driver = restTemplate.getForObject(baseURL + "/NationalDriver/1", NationalDriver.class);
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