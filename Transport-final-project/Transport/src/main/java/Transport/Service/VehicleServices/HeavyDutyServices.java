package Transport.Service.VehicleServices;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Repository.Impl.VehicleRepoImplementations.HeavyDutyRepositoryImpl;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface HeavyDutyServices extends MainService<HeavyDuty, String>
{
    ArrayList<HeavyDuty> getAll();
}
