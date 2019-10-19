package Transport.Repository.Repositories.VehicleRepositories;

import Transport.Domain.Vehicles.Bus;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface BusRepository extends MainRepository<Bus, String>
{
    ArrayList<Bus> getAll();
}
