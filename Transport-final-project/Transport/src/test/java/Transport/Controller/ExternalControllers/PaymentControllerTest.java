package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Payment;
import Transport.Factory.ExternalFactories.PaymentFactory;
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

public class PaymentControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Payment";

    @Test
    public void create()
    {
        Payment payment = PaymentFactory.getPayment(300,"08473648", "RD2367", true);

        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(baseURL + "/create", payment, Payment.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void update()
    {
        String id = "AD5467";

        Payment payment = restTemplate.getForObject(baseURL + "/Payment/" + id, Payment.class);

        restTemplate.put(baseURL + "/payments/" + id, payment);
        Payment updatedPayment = restTemplate.getForObject(baseURL + "/Payment/" + id, Payment.class);
        Assert.assertNotNull(updatedPayment);
    }

    @Test
    public void delete()
    {
        String id = "AC3456";

        Payment payment = restTemplate.getForObject(baseURL + "/Payment/" + id, Payment.class);
        Assert.assertNotNull(payment);
        restTemplate.delete(baseURL + "/Payment/" + id);

        try
        {
            payment = restTemplate.getForObject(baseURL + "/Payment/" + id, Payment.class);
        }

        catch(final HttpClientErrorException e)
        {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read()
    {
        Payment payment = restTemplate.getForObject(baseURL + "/Payment/1", Payment.class);
        System.out.println(payment.getFineNum());
        Assert.assertNotNull(payment);
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