package Transport.Repository.Impl.VehicleRepoImplTests;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.MotobikeFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.MotorbikeRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MotorbikeRepositoryImplTest {

    MotorbikeRepositoryImpl val = MotorbikeRepositoryImpl.getRepo();
    MotobikeFactory object = new MotobikeFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    Motorbike value = object.getMotorbike("Blue","Dugati", veh1);
    Motorbike value2 = object.getMotorbike("Black","Kawasaki", veh2);
    Motorbike value3 = object.getMotorbike("Pink","Dugati", veh1);



    @Test
    public void create()
    {
        val.create(value);
        val.create(value2);

        int amount = val.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        val.create(value);
        val.create(value2);

        Motorbike b = val.update(value3);

        Assert.assertEquals(value3, b);
    }

    @Test
    public void delete()
    {
        val.create(value);
        val.create(value2);

        String element = value.getVeh().getVehicleLicense();

        val.delete(element);

        int amount = val.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        val.create(value);
        val.create(value2);

        String element = value.getVeh().getVehicleLicense();

        Motorbike c = val.read(element);

        Assert.assertEquals(value, c);
    }

    @Test
    public void getAll()
    {
        val.create(value);
        val.create(value2);

        int amount = val.getAll().size();

        Assert.assertEquals(2,amount);
    }
}