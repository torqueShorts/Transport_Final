package Transport.Repository.Impl.VehicleRepoImplTests;

import Transport.Domain.Vehicles.Taxi;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.TaxiFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.TaxiRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiRepositoryImplTest {


    TaxiRepositoryImpl val = TaxiRepositoryImpl.getRepo();
    TaxiFactory object = new TaxiFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    Taxi value = object.getTaxi("Blue","Gorrow", veh1);
    Taxi value2 = object.getTaxi("Black","Miti", veh2);
    Taxi value3 = object.getTaxi("Pink","Gorrow", veh1);



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

        Taxi b = val.update(value3);

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

        Taxi c = val.read(element);

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