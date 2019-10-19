package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Payment;
import Transport.Factory.ExternalFactories.PaymentFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.PaymentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PaymentServiceImplTest {

    private PaymentRepositoryImpl repository;

    PaymentFactory object = new PaymentFactory();

    Payment value = object.getPayment(300,"08473648", "RD2367", true);
    Payment value2 = object.getPayment(200, "08174837", "NB3746", false);
    Payment value3 = object.getPayment(400, "08473648", "MB47453", false);


    @Before
    public void setUp() throws Exception
    {
        this.repository = PaymentRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Payment> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Payment created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Payment updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getFineNum());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Payment saved = this.repository.read(value.getFineNum());

        Assert.assertEquals(value, saved);
    }
}