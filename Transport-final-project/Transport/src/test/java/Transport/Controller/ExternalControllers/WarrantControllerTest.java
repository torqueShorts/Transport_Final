package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Warrant;
import Transport.Factory.ExternalFactories.WarrantFactory;
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

public class WarrantControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Warrant";

    @Test
    public void create()
    {
        Warrant warrant = WarrantFactory.getWarrant("RD2345", "08453627", "RC3627463", true);

        ResponseEntity<Warrant> postResponse = restTemplate.postForEntity(baseURL + "/create", warrant, Warrant.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Warrant warrant = restTemplate.getForObject(baseURL + "/Warrant/" + id, Warrant.class);

        restTemplate.put(baseURL + "/warrants/" + id, warrant);
        Warrant updatedWarrant = restTemplate.getForObject(baseURL + "/Warrant/" + id, Warrant.class);
        Assert.assertNotNull(updatedWarrant);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Warrant warrant = restTemplate.getForObject(baseURL + "/warrants/" + id, Warrant.class);
        Assert.assertNotNull(warrant);
        restTemplate.delete(baseURL + "/warrants/" + id);

        try
        {
            warrant = restTemplate.getForObject(baseURL + "/warrants/" + id, Warrant.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Warrant warrant = restTemplate.getForObject(baseURL + "/warrant/1", Warrant.class);
        System.out.println(warrant.getWarrantID());
        Assert.assertNotNull(warrant);
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