package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.HeavyDutyFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.HeavyDutyRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.HeavyDutyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HeavyDutyServiceImplTest {

    private HeavyDutyRepositoryImpl repository;

    HeavyDutyFactory object = new HeavyDutyFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    HeavyDuty value = object.getHeavyDuty("Blue","ForkLift", veh1);
    HeavyDuty value2 = object.getHeavyDuty("Black","Crane", veh2);
    HeavyDuty value3 = object.getHeavyDuty("Pink","FokLift", veh1);



    @Before
    public void setUp() throws Exception
    {
        this.repository = HeavyDutyRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<HeavyDuty> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        HeavyDuty created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        HeavyDuty updated = this.repository.update(value3);

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
        HeavyDuty saved = this.repository.read(value.getVeh().getVehicleLicense());

        Assert.assertEquals(value, saved);
    }
}