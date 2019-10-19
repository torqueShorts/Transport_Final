package Transport.Repository.Repositories.VehicleRepositories;

import Transport.Domain.Vehicles.Taxi;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface TaxiRepository extends MainRepository <Taxi, String>
{
    ArrayList<Taxi> getAll();
}
