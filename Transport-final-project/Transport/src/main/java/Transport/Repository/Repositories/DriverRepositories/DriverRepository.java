package Transport.Repository.Repositories.DriverRepositories;

import Transport.Domain.Drivers.Driver;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface DriverRepository extends MainRepository<Driver, String>
{
    ArrayList<Driver> getAll();
}
