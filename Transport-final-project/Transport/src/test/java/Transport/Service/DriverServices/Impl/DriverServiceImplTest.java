package Transport.Service.DriverServices.Impl;

import Transport.Domain.Drivers.Driver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Repository.Impl.DriverRepoImplementations.DriverRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DriverServiceImplTest {

    private DriverRepositoryImpl repository;

    DriverFactory dri = new DriverFactory();

    Driver value = dri.getDriver("081475354", "AC7465993", true);
    Driver value2 = dri.getDriver("081374657", "AC465498", false);
    Driver value3 = dri.getDriver("081374657", "AC461234", false);

    @Before
    public void setUp() throws Exception
    {
        this.repository = DriverRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Driver> drivers = this.repository.getAll();
        Assert.assertEquals(drivers, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Driver created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Driver updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getDriverID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Driver saved = this.repository.read(value.getDriverID());

        Assert.assertEquals(value, saved);
    }
}