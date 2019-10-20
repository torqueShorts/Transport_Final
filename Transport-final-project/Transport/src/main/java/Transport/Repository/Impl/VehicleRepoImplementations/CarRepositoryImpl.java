package Transport.Repository.Impl.VehicleRepoImplementations;

import Transport.Domain.Vehicles.Car;
import Transport.Repository.Repositories.VehicleRepositories.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class CarRepositoryImpl implements CarRepository
{
    private static CarRepositoryImpl repo = null;
    private ArrayList<Car> cars;

    private CarRepositoryImpl()
    {
        this.cars = new ArrayList<Car>();
    }

    public static CarRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new CarRepositoryImpl();
        }

        return repo;
    }



    @Override
    public Car create(Car car)
    {
        this.cars.add(car);
        return car;
    }

    @Override
    public Car update(Car car)
    {

        int count = 1;

        Car val = null;

        for(int i = 0; i < cars.size(); i++)
        {
            if(cars.get(i).getVeh().getVehicleLicense() == car.getVeh().getVehicleLicense())
            {
                cars.set(i,car);
                count--;
                val = cars.get(i);
                System.out.println("Car updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Car not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;


        for(int i = 0; i < cars.size(); i++)
        {
            if(cars.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                cars.remove(i);
                count--;
                System.out.println("car removed");
            }
        }

        if(count > 0)
        {
            System.out.println("car not found");
        }

    }

    @Override
    public Car read(String obj)
    {

        int count = 1;

        Car val = null;

        for(int i = 0; i < cars.size(); i++)
        {
            if(cars.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                val = cars.get(i);
                count--;
                System.out.println("Car read");
            }
        }

        if(count > 0)
        {
            System.out.println("Car not found");
        }


        return val;
    }

    @Override
    public ArrayList<Car> getAll() {
        return this.cars;
    }

}
