package Transport.Repository.Repositories.VehicleRepositories;


import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface HeavyDutyRepository extends MainRepository <HeavyDuty, String>
{
    ArrayList<HeavyDuty> getAll();
}
