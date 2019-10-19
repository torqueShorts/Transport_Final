package Transport.Repository.Repositories.DepartmentRepositories;

import Transport.Domain.Department.TrafficOfficer;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface TrafficOfficerRepository extends MainRepository<TrafficOfficer, String>
{
    ArrayList<TrafficOfficer> getAll();

}
