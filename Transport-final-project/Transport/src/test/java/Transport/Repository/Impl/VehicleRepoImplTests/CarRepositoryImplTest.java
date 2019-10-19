package Transport.Repository.Impl.VehicleRepoImplTests;

import Transport.Domain.Vehicles.Car;
import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.CarFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import Transport.Repository.Impl.VehicleRepoImplementations.CarRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class CarRepositoryImplTest {

    CarRepositoryImpl car = CarRepositoryImpl.getRepo();
    CarFactory object = new CarFactory();

    VehicleFactory veh = new VehicleFactory();

    Vehicle veh1 = veh.getVehicle("AC74385", "Car", "081489359");
    Vehicle veh2 = veh.getVehicle("AC83647", "Car", "082546483");


    Car value = object.getCar("Blue","BMW", veh1);
    Car value2 = object.getCar("Black","Toyota", veh2);
    Car value3 = object.getCar("Pink","BMW", veh1);


    @Test
    public void create()
    {
        car.create(value);
        car.create(value2);

        int amount = car.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        car.create(value);
        car.create(value2);

        Car c = car.update(value3);

        Assert.assertEquals(value3, c);
    }

    @Test
    public void delete()
    {
        car.create(value);
        car.create(value2);

        String element = value.getVeh().getVehicleLicense();

        car.delete(element);

        int amount = car.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        car.create(value);
        car.create(value2);

        String element = value.getVeh().getVehicleLicense();

        Car c = car.read(element);

        Assert.assertEquals(value, c);

    }

    @Test
    public void getAll()
    {
        car.create(value);
        car.create(value2);

        int amount = car.getAll().size();

        Assert.assertEquals(2,amount);
    }
}