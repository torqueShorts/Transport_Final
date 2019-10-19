package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Trial;
import Transport.Factory.ExternalFactories.TrialFactory;
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

public class TrialControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Trial";

    @Test
    public void create()
    {
        Trial trial= TrialFactory.getTrial("RC2345", "12/08/2019", "0818274", "ARD12737");

        ResponseEntity<Trial> postResponse = restTemplate.postForEntity(baseURL + "/create", trial, Trial.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Trial trial = restTemplate.getForObject(baseURL + "/Trial/" + id, Trial.class);

        restTemplate.put(baseURL + "/Trial/" + id, trial);
        Trial updatedTrial = restTemplate.getForObject(baseURL + "/Trial/" + id, Trial.class);
        Assert.assertNotNull(updatedTrial);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Trial trial = restTemplate.getForObject(baseURL + "/Trial/" + id, Trial.class);
        Assert.assertNotNull(trial);
        restTemplate.delete(baseURL + "/Trial/" + id);

        try
        {
            trial = restTemplate.getForObject(baseURL + "/Trial/" + id, Trial.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Trial trial = restTemplate.getForObject(baseURL + "/Trial/1", Trial.class);
        System.out.println(trial.getTrialID());
        Assert.assertNotNull(trial);
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