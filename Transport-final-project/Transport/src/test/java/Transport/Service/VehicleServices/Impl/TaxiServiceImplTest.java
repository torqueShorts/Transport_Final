package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Taxi;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.TaxiFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.TaxiRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.TaxiRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TaxiServiceImplTest {

    private TaxiRepositoryImpl repository;

    TaxiFactory object = new TaxiFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    Taxi value = object.getTaxi("Blue","Gorrow", veh1);
    Taxi value2 = object.getTaxi("Black","Miti", veh2);
    Taxi value3 = object.getTaxi("Pink","Gorrow", veh1);

    @Before
    public void setUp() throws Exception
    {
        this.repository = TaxiRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Taxi> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Taxi created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Taxi updated = this.repository.update(value3);

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
        Taxi saved = this.repository.read(value.getVeh().getVehicleLicense());

        Assert.assertEquals(value, saved);
    }
}