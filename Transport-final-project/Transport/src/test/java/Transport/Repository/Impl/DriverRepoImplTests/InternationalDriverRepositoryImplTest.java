package Transport.Repository.Impl.DriverRepoImplTests;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.InternationalDriver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Factory.DriversFactories.InternationalDriverFactory;
import Transport.Repository.Impl.DriverRepoImplementations.InternationalDriverRepositoryImpl;
import Transport.Repository.Repositories.DriverRepositories.InternationalDriverRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InternationalDriverRepositoryImplTest {

    InternationalDriverRepository driver = InternationalDriverRepositoryImpl.getRepo();
    InternationalDriverFactory dri = new InternationalDriverFactory();

    DriverFactory drive = new DriverFactory();

    Driver d1 = drive.getDriver("AR2161","BC3456", true);
    Driver d2 = drive.getDriver("FR4563", "BN3764", true);
    Driver d3 = drive.getDriver("FR4563", "BN3764", true);

    InternationalDriver value = dri.getInternationalDriver("Samantha", "Lorris", "09/02/1997", true,d1 );
    InternationalDriver value2 = dri.getInternationalDriver("John","Nelson", "08/01/1997", true, d2);
    InternationalDriver value3 = dri.getInternationalDriver("James","Benson", "08/01/1997", true, d3);



    @Test
    public void create()
    {
        driver.create(value);
        driver.create(value2);

        int amount = driver.getAll().size();

        Assert.assertEquals(2,amount);

    }

    @Test
    public void update()
    {
        driver.create(value);
        driver.create(value2);

        InternationalDriver element = driver.update(value3);

        Assert.assertEquals(value3,element);

    }

    @Test
    public void delete()
    {
        driver.create(value);
        driver.create(value2);

        String element = value.getDrive().getDriverID();

        driver.delete(element);

        int amount = driver.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        driver.create(value);
        driver.create(value2);

        String element = "081475354";

        InternationalDriver driveValue = driver.read(element);

        Assert.assertEquals(value, driveValue);
    }

    @Test
    public void getAll()
    {
        driver.create(value);
        driver.create(value2);

        int amount = driver.getAll().size();

        Assert.assertEquals(2, amount);
    }
}