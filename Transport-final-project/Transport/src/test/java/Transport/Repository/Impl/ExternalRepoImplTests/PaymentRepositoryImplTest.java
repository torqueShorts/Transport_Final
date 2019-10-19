package Transport.Repository.Impl.ExternalRepoImplTests;

import Transport.Domain.External.Payment;
import Transport.Factory.ExternalFactories.PaymentFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.PaymentRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class PaymentRepositoryImplTest {

    PaymentRepositoryImpl payment = PaymentRepositoryImpl.getRepo();
    PaymentFactory object = new PaymentFactory();

    Payment value = object.getPayment(300,"08473648", "RD2367", true);
    Payment value2 = object.getPayment(200, "08174837", "NB3746", false);
    Payment value3 = object.getPayment(400, "08473648", "MB47453", false);


    @Test
    public void create()
    {
        payment.create(value);
        payment.create(value2);

        int amount = payment.getAll().size();

        Assert.assertEquals(2, amount);

    }

    @Test
    public void update()
    {
        payment.create(value);
        payment.create(value2);

        Payment pay = payment.update(value3);

        Assert.assertEquals(value3, pay);

    }

    @Test
    public void delete()
    {
        payment.create(value);
        payment.create(value2);

        String element = value.getDriverID();

        payment.delete(element);

        int amount = payment.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        payment.create(value);
        payment.create(value2);

        String element = value.getDriverID();

        Payment payValue = payment.read(element);

        Assert.assertEquals(value, payValue);

    }

    @Test
    public void getAll()
    {
        payment.create(value);
        payment.create(value2);

        int amount = payment.getAll().size();

        Assert.assertEquals(2,amount);


    }
}