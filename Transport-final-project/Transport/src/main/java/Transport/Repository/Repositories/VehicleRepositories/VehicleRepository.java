package Transport.Repository.Repositories.VehicleRepositories;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface VehicleRepository extends MainRepository<Vehicle, String>
{

    ArrayList<Vehicle> getAll();

}
