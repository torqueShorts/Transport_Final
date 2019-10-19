package Transport.Controller.ExternalControllers;


import Transport.Domain.External.Verdict;
import Transport.Factory.ExternalFactories.VerdictFactory;
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

public class VerdictControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Verdict";

    @Test
    public void create()
    {
        Verdict verdict = VerdictFactory.getVerdict("RC2345", false, 300, true);

        ResponseEntity<Verdict> postResponse = restTemplate.postForEntity(baseURL + "/create", verdict, Verdict.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Verdict verdict = restTemplate.getForObject(baseURL + "/Verdict/" + id, Verdict.class);

        restTemplate.put(baseURL + "/verdicts/" + id, verdict);
        Verdict updatedVerdict = restTemplate.getForObject(baseURL + "/Verdict/" + id, Verdict.class);
        Assert.assertNotNull(updatedVerdict);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Verdict verdict = restTemplate.getForObject(baseURL + "/Verdict/" + id, Verdict.class);
        Assert.assertNotNull(verdict);
        restTemplate.delete(baseURL + "/Verdict/" + id);

        try
        {
            verdict = restTemplate.getForObject(baseURL + "/Verdict/" + id, Verdict.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Verdict verdict = restTemplate.getForObject(baseURL + "/Verdict/1", Verdict.class);
        System.out.println(verdict.getFineNum());
        Assert.assertNotNull(verdict);
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