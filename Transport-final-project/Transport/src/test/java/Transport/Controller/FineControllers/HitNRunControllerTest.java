package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.HitNRunFactory;
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

public class HitNRunControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/hitNRun";

    @Test
    public void create()
    {
        Fine fin = FineFactory.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);

        HitNRun hitNRun = HitNRunFactory.getHitNRun("OverSpeedLimitLow","08/04/1986", fin);

        ResponseEntity<HitNRun> postResponse = restTemplate.postForEntity(baseURL + "/create", hitNRun, HitNRun.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        HitNRun hitNRun = restTemplate.getForObject(baseURL + "/hitNRun/" + id, HitNRun.class);

        restTemplate.put(baseURL + "/hitNRun/" + id, hitNRun);
        HitNRun updatedHitNRun = restTemplate.getForObject(baseURL + "/HitNRun/" + id, HitNRun.class);
        Assert.assertNotNull(updatedHitNRun);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        HitNRun hitNRun = restTemplate.getForObject(baseURL + "/hitNRun/" + id, HitNRun.class);
        Assert.assertNotNull(hitNRun);
        restTemplate.delete(baseURL + "/hitNRun/" + id);

        try
        {
            hitNRun = restTemplate.getForObject(baseURL + "/hitNRun/" + id, HitNRun.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        HitNRun hitNRun = restTemplate.getForObject(baseURL + "/hitNRun/1", HitNRun.class);
        System.out.println(hitNRun.getFine().getFineNum());
        Assert.assertNotNull(hitNRun);
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