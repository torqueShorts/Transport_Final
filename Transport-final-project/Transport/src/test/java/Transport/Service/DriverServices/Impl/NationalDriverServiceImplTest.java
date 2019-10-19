package Transport.Service.DriverServices.Impl;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.NationalDriver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Factory.DriversFactories.NationalDriverFactory;
import Transport.Repository.Impl.DriverRepoImplementations.NationalDriverRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NationalDriverServiceImplTest {

    private NationalDriverRepositoryImpl repository;

    NationalDriverFactory dri = new NationalDriverFactory();

    DriverFactory drive = new DriverFactory();

    Driver d1 = drive.getDriver("AR2161","BC3456", true);
    Driver d2 = drive.getDriver("FR4563", "BN3764", true);
    Driver d3 = drive.getDriver("FR4563", "BN3764", true);

    NationalDriver value = dri.getNationalDriver("Samantha", "Lorris", "09/02/1997",d1 );
    NationalDriver value2 = dri.getNationalDriver("John","Nelson", "08/01/1997", d2);
    NationalDriver value3 = dri.getNationalDriver("James","Benson", "08/01/1997", d3);


    @Before
    public void setUp() throws Exception
    {
        this.repository = NationalDriverRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<NationalDriver> drivers = this.repository.getAll();
        Assert.assertEquals(drivers, this.repository.getAll());
    }

    @Test
    public void create()
    {
        NationalDriver created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        NationalDriver updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getDrive().getDriverID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        NationalDriver saved = this.repository.read(value.getDrive().getDriverID());

        Assert.assertEquals(value, saved);
    }
}