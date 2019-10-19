package Transport.Security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransportationSecurityTest {

    private static final String BASE_URL = "http://localhost:8080/TrafficChief";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void CheckIfDetailsAreCorrect()
    {
//      This should display 200 OK due to the username and password being correct
        ResponseEntity<String> authentication = testRestTemplate.withBasicAuth("admin", "PASSWORD")
                .getForEntity(BASE_URL + "/read/all", String.class);
        System.out.println(authentication.getBody());
        System.out.println(authentication.getStatusCode());
        assertEquals(HttpStatus.OK, authentication.getStatusCode());
    }

    @Test
    public void CheckIfDetailsAreIncorrect()
    {
//      This should display 401 unauthorized due to the password being incorrect
        ResponseEntity<String> authentication = testRestTemplate.withBasicAuth("admin", "admin")
                .getForEntity(BASE_URL + "/read/all", String.class);
        System.out.println(authentication.getBody());
        System.out.println(authentication.getStatusCode());
        assertEquals(HttpStatus.UNAUTHORIZED, authentication.getStatusCode());
    }





}