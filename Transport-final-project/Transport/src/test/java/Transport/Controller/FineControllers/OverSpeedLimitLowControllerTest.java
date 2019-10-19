package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.OverSpeedLimitLowFactory;
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

public class OverSpeedLimitLowControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/overSpeedLimitLow";

    @Test
    public void create()
    {
        Fine fin = FineFactory.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);

        OverSpeedLimitLow overSpeedLimitLow = OverSpeedLimitLowFactory.getOverSpeedLimitLow(60,100,300,fin);

        ResponseEntity<OverSpeedLimitLow> postResponse = restTemplate.postForEntity(baseURL + "/create", overSpeedLimitLow, OverSpeedLimitLow.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        OverSpeedLimitLow overSpeedLimitLow= restTemplate.getForObject(baseURL + "/overSpeedLimitLow/" + id, OverSpeedLimitLow.class);

        restTemplate.put(baseURL + "/overSpeedLimitLow/" + id, overSpeedLimitLow);
        OverSpeedLimitLow updatedOverSpeedLimitLow = restTemplate.getForObject(baseURL + "/OverSpeedLimitLow/" + id, OverSpeedLimitLow.class);
        Assert.assertNotNull(updatedOverSpeedLimitLow);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        OverSpeedLimitLow overSpeedLimitLow = restTemplate.getForObject(baseURL + "/overSpeedLimitLow/" + id, OverSpeedLimitLow.class);
        Assert.assertNotNull(overSpeedLimitLow);
        restTemplate.delete(baseURL + "/overSpeedLimitLow/" + id);

        try
        {
            overSpeedLimitLow = restTemplate.getForObject(baseURL + "/overSpeedLimitLow/" + id, OverSpeedLimitLow.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        OverSpeedLimitLow overSpeedLimitLow = restTemplate.getForObject(baseURL + "/overSpeedLimitLow/1", OverSpeedLimitLow.class);
        System.out.println(overSpeedLimitLow.getFine().getFineNum());
        Assert.assertNotNull(overSpeedLimitLow);
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