package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Car;
import Transport.Repository.Impl.VehicleRepoImplementations.CarRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.CarRepository;
import Transport.Service.VehicleServices.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("CarServiceImpl")

public class CarServiceImpl implements CarService
{
    @Autowired
    @Qualifier("CarRepo")

    private static CarServiceImpl service = null;
    private CarRepository repository;

    private CarServiceImpl()
    {
        this.repository = CarRepositoryImpl.getRepo();
    }

    public static CarServiceImpl getService()
    {
        if(service == null)
        {
            service = new CarServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<Car> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Car create(Car type) {
        return this.repository.create(type);
    }

    @Override
    public Car update(Car type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Car read(String s) {
        return this.repository.read(s);
    }
}
