package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.MotobikeFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.MotorbikeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MotorbikeServiceImplTest {

    private MotorbikeRepositoryImpl repository;

    MotobikeFactory object = new MotobikeFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Bus", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Bus", "082546483");


    Motorbike value = object.getMotorbike("Blue","Dugati", veh1);
    Motorbike value2 = object.getMotorbike("Black","Kawasaki", veh2);
    Motorbike value3 = object.getMotorbike("Pink","Dugati", veh1);

    @Before
    public void setUp() throws Exception
    {
        this.repository = MotorbikeRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Motorbike> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Motorbike created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Motorbike updated = this.repository.update(value3);

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
        Motorbike saved = this.repository.read(value.getVeh().getVehicleLicense());

        Assert.assertEquals(value, saved);
    }
}