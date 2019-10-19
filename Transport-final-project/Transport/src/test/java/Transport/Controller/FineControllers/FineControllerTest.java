package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
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

public class FineControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/fine";

    @Test
    public void create()
    {
        Fine fine = FineFactory.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);


        ResponseEntity<Fine> postResponse = restTemplate.postForEntity(baseURL + "/create", fine, Fine.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Fine fine = restTemplate.getForObject(baseURL + "/fine/" + id, Fine.class);

        restTemplate.put(baseURL + "/fine/" + id, fine);
        Fine updatedFine = restTemplate.getForObject(baseURL + "/Fine/" + id, Fine.class);
        Assert.assertNotNull(updatedFine);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Fine fine = restTemplate.getForObject(baseURL + "/fine/" + id, Fine.class);
        Assert.assertNotNull(fine);
        restTemplate.delete(baseURL + "/fine/" + id);

        try
        {
            fine = restTemplate.getForObject(baseURL + "/fine/" + id, Fine.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Fine fine = restTemplate.getForObject(baseURL + "/fine/1", Fine.class);
        System.out.println(fine.getFineNum());
        Assert.assertNotNull(fine);
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