package Transport.Repository.Impl.VehicleRepoImplTests;

import Transport.Domain.Vehicles.Bus;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.BusFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.BusRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusRepositoryImplTest {

    BusRepositoryImpl bus = BusRepositoryImpl.getRepo();
    BusFactory object = new BusFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    Bus value = object.getBus("Blue","Golden Arrow", veh1);
    Bus value2 = object.getBus("Black","My citi", veh2);
    Bus value3 = object.getBus("Pink","Golden Arrow", veh1);



    @Test
    public void create()
    {
        bus.create(value);
        bus.create(value2);

        int amount = bus.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        bus.create(value);
        bus.create(value2);

        Bus b = bus.update(value3);

        Assert.assertEquals(value3, b);
    }

    @Test
    public void delete()
    {
        bus.create(value);
        bus.create(value2);

        String element = value.getVeh().getVehicleLicense();

        bus.delete(element);

        int amount = bus.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        bus.create(value);
        bus.create(value2);

        String element = value.getVeh().getVehicleLicense();

        Bus c = bus.read(element);

        Assert.assertEquals(value, c);
    }

    @Test
    public void getAll()
    {
        bus.create(value);
        bus.create(value2);

        int amount = bus.getAll().size();

        Assert.assertEquals(2,amount);
    }
}