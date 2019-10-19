package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.MinorOffenseFactory;
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

public class MinorOffenseControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/minorOffense";

    @Test
    public void create()
    {
        Fine fin = FineFactory.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);

        MinorOffense minorOffense = MinorOffenseFactory.getMinorOffense("OverSpeedLimitLow", fin);

        ResponseEntity<MinorOffense> postResponse = restTemplate.postForEntity(baseURL + "/create", minorOffense, MinorOffense.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        MinorOffense minorOffense = restTemplate.getForObject(baseURL + "/minorOffense/" + id, MinorOffense.class);

        restTemplate.put(baseURL + "/minorOffense/" + id, minorOffense);
        MinorOffense updatedMinoroffense = restTemplate.getForObject(baseURL + "/MinorOffense/" + id, MinorOffense.class);
        Assert.assertNotNull(updatedMinoroffense);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        MinorOffense minorOffense = restTemplate.getForObject(baseURL + "/minorOffense/" + id, MinorOffense.class);
        Assert.assertNotNull(minorOffense);
        restTemplate.delete(baseURL + "/minorOffense/" + id);

        try
        {
            minorOffense = restTemplate.getForObject(baseURL + "/minorOffense/" + id, MinorOffense.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        MinorOffense minorOffense = restTemplate.getForObject(baseURL + "/MinorOffense/1", MinorOffense.class);
        System.out.println(minorOffense.getFine().getFineNum());
        Assert.assertNotNull(minorOffense);
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