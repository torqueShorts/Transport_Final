package Transport.Repository.Repositories.VehicleRepositories;

import Transport.Domain.Vehicles.Car;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface CarRepository extends MainRepository<Car, String>
{

    ArrayList<Car> getAll();
}
