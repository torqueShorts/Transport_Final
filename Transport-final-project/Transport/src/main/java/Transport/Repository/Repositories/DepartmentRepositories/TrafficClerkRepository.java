package Transport.Repository.Repositories.DepartmentRepositories;

import Transport.Domain.Department.TrafficClerk;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface TrafficClerkRepository extends MainRepository<TrafficClerk, String>
{
    ArrayList<TrafficClerk> getAll();
}
