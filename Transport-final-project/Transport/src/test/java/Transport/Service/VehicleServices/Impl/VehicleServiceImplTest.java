package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.VehicleRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VehicleServiceImplTest {

    private VehicleRepositoryImpl repository;

    VehicleFactory val = new VehicleFactory();

    Vehicle value = val.getVehicle("AC7465993","Car", "08473648");
    Vehicle value2 = val.getVehicle("AC465498", "Motobike", "08174837");
    Vehicle value3 = val.getVehicle("AC461234", "HeavyDuty", "082437850");

    @Before
    public void setUp() throws Exception
    {
        this.repository = VehicleRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Vehicle> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Vehicle created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Vehicle updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getVehicleLicense());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Vehicle saved = this.repository.read(value.getVehicleLicense());

        Assert.assertEquals(value, saved);
    }
}