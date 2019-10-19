package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Car;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.CarFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.CarRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarServiceImplTest {

    private CarRepositoryImpl repository;

    CarFactory object = new CarFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Car", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Car", "082546483");


    Car value = object.getCar("Blue","BMW", veh1);
    Car value2 = object.getCar("Black","Toyota", veh2);
    Car value3 = object.getCar("Pink","BMW", veh1);


    @Before
    public void setUp() throws Exception
    {
        this.repository = CarRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Car> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Car created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Car updated = this.repository.update(value3);

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
        Car saved = this.repository.read(value.getVeh().getVehicleLicense());

        Assert.assertEquals(value, saved);
    }
}