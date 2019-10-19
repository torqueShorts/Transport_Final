package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Court;
import Transport.Factory.ExternalFactories.CourtFactory;
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


public class CourtControllerTest
{

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Court";

    @Test
    public void create()
    {
        Court court = CourtFactory.getCourt("Larrisons Court","AR3456", "Lucas Ericson" );

        ResponseEntity<Court> postResponse = restTemplate.postForEntity(baseURL + "/create", court, Court.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Court court = restTemplate.getForObject(baseURL + "/Court/" + id, Court.class);

        restTemplate.put(baseURL + "/courts/" + id, court);
        Court updatedCourt = restTemplate.getForObject(baseURL + "/Court/" + id, Court.class);
        Assert.assertNotNull(updatedCourt);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Court court = restTemplate.getForObject(baseURL + "/Court/" + id, Court.class);
        Assert.assertNotNull(court);
        restTemplate.delete(baseURL + "/Court/" + id);

        try
        {
            court = restTemplate.getForObject(baseURL + "/Court/" + id, Court.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Court court = restTemplate.getForObject(baseURL + "/Court/1", Court.class);
        System.out.println(court.getCourtName());
        Assert.assertNotNull(court);
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