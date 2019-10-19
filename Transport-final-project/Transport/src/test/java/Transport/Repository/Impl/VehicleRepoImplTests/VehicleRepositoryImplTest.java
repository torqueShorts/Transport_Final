package Transport.Repository.Impl.VehicleRepoImplTests;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.VehicleRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class VehicleRepositoryImplTest {

    VehicleRepositoryImpl vehicle = VehicleRepositoryImpl.getRepo();
    VehicleFactory val = new VehicleFactory();

    Vehicle value = val.getVehicle("AC7465993","Car", "08473648");
    Vehicle value2 = val.getVehicle("AC465498", "Motobike", "08174837");
    Vehicle value3 = val.getVehicle("AC461234", "HeavyDuty", "082437850");


    @Test
    public void create()
    {
        vehicle.create(value);
        vehicle.create(value2);

        int amount = vehicle.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        vehicle.create(value);
        vehicle.create(value2);

        Vehicle vel = vehicle.update(value3);

        Assert.assertEquals(value3, vel);

    }

    @Test
    public void delete()
    {
        vehicle.create(value);
        vehicle.create(value2);

        String element = value.getDriverID();

        vehicle.delete(element);

        int amount = vehicle.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        vehicle.create(value);
        vehicle.create(value2);

        String element = value.getDriverID();

        Vehicle vehValue = vehicle.read(element);

        Assert.assertEquals(value, vehValue);

    }

    @Test
    public void getAll()
    {
        vehicle.create(value);
        vehicle.create(value2);

        int amount = vehicle.getAll().size();

        Assert.assertEquals(2,amount);
    }
}