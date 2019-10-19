package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.MajorOffenseFactory;
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

public class MajorOffenseControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/majorOffense";

    @Test
    public void create()
    {
        Fine fin = FineFactory.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);

        MajorOffense majorOffense = MajorOffenseFactory.getMajorOffense("OverSpeedLimitLow", fin);

        ResponseEntity<MajorOffense> postResponse = restTemplate.postForEntity(baseURL + "/create", majorOffense, MajorOffense.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        MajorOffense majorOffense = restTemplate.getForObject(baseURL + "/majorOffense/" + id, MajorOffense.class);

        restTemplate.put(baseURL + "/majorOffense/" + id, majorOffense);
        MajorOffense updatedMajorOffense = restTemplate.getForObject(baseURL + "/MajorOffense/" + id, MajorOffense.class);
        Assert.assertNotNull(updatedMajorOffense);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        MajorOffense majorOffense = restTemplate.getForObject(baseURL + "/majorOffense/" + id, MajorOffense.class);
        Assert.assertNotNull(majorOffense);
        restTemplate.delete(baseURL + "/majorOffense/" + id);

        try
        {
            majorOffense = restTemplate.getForObject(baseURL + "/majorOffense/" + id, MajorOffense.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        MajorOffense majorOffense = restTemplate.getForObject(baseURL + "/majorOffense/1", MajorOffense.class);
        System.out.println(majorOffense.getFine().getFineNum());
        Assert.assertNotNull(majorOffense);
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