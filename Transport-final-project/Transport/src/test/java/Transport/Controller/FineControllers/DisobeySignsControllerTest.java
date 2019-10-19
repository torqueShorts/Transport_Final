package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.DisobeySignsFactory;
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

public class DisobeySignsControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/disObeySigns";

    @Test
    public void create()
    {
        Fine fin = FineFactory.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);

        DisobeySigns disobeySigns = DisobeySignsFactory.getDisobeySign("OverSpeedLimitLow",100, fin);

        ResponseEntity<DisobeySigns> postResponse = restTemplate.postForEntity(baseURL + "/create", disobeySigns, DisobeySigns.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        DisobeySigns disobeySigns = restTemplate.getForObject(baseURL + "/disObeySigns/" + id, DisobeySigns.class);

        restTemplate.put(baseURL + "/disObeySigns/" + id, disobeySigns);
        DisobeySigns updatedSign = restTemplate.getForObject(baseURL + "/DisObeySigns/" + id, DisobeySigns.class);
        Assert.assertNotNull(updatedSign);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        DisobeySigns disobeySigns = restTemplate.getForObject(baseURL + "/disObeySigns/" + id, DisobeySigns.class);
        Assert.assertNotNull(disobeySigns);
        restTemplate.delete(baseURL + "/disObeySigns/" + id);

        try
        {
            disobeySigns = restTemplate.getForObject(baseURL + "/disObeySigns/" + id, DisobeySigns.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        DisobeySigns disobeySigns = restTemplate.getForObject(baseURL + "/disObeySigns/1", DisobeySigns.class);
        System.out.println(disobeySigns.getFine().getFineNum());
        Assert.assertNotNull(disobeySigns);
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