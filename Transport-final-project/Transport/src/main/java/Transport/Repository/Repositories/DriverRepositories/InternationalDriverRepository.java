package Transport.Repository.Repositories.DriverRepositories;

import Transport.Domain.Drivers.InternationalDriver;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface InternationalDriverRepository extends MainRepository <InternationalDriver, String>
{
    ArrayList<InternationalDriver> getAll();
}
