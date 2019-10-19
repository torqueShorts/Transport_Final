package Transport.Repository.Impl.VehicleRepoImplTests;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.HeavyDutyFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.HeavyDutyRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeavyDutyRepositoryImplTest {

    HeavyDutyRepositoryImpl heavy = HeavyDutyRepositoryImpl.getRepo();
    HeavyDutyFactory object = new HeavyDutyFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    HeavyDuty value = object.getHeavyDuty("Blue","ForkLift", veh1);
    HeavyDuty value2 = object.getHeavyDuty("Black","Crane", veh2);
    HeavyDuty value3 = object.getHeavyDuty("Pink","FokLift", veh1);



    @Test
    public void create()
    {
        heavy.create(value);
        heavy.create(value2);

        int amount = heavy.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        heavy.create(value);
        heavy.create(value2);

        HeavyDuty b = heavy.update(value3);

        Assert.assertEquals(value3, b);
    }

    @Test
    public void delete()
    {
        heavy.create(value);
        heavy.create(value2);

        String element = value.getVeh().getVehicleLicense();

        heavy.delete(element);

        int amount = heavy.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        heavy.create(value);
        heavy.create(value2);

        String element = value.getVeh().getVehicleLicense();

        HeavyDuty c = heavy.read(element);

        Assert.assertEquals(value, c);
    }

    @Test
    public void getAll()
    {
        heavy.create(value);
        heavy.create(value2);

        int amount = heavy.getAll().size();

        Assert.assertEquals(2,amount);
    }
}