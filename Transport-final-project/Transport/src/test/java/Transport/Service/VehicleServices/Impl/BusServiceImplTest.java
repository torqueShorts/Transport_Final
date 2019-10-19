package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Bus;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.BusFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.BusRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BusServiceImplTest {

    private BusRepositoryImpl repository;

    BusFactory object = new BusFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    Bus value = object.getBus("Blue","Golden Arrow", veh1);
    Bus value2 = object.getBus("Black","My citi", veh2);
    Bus value3 = object.getBus("Pink","Golden Arrow", veh1);

    @Before
    public void setUp() throws Exception
    {
        this.repository = BusRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Bus> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Bus created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Bus updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getVeh().getVehicleLicense());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Bus saved = this.repository.read(value.getVeh().getVehicleLicense());

        Assert.assertEquals(value, saved);
    }
}