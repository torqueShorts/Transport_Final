package Transport.Repository.Repositories.DriverRepositories;

import Transport.Domain.Drivers.NationalDriver;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface NationalDriverRepository extends MainRepository <NationalDriver, String>
{
    ArrayList<NationalDriver> getAll();
}
