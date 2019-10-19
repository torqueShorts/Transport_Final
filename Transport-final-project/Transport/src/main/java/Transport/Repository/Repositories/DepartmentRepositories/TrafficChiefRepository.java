package Transport.Repository.Repositories.DepartmentRepositories;

import Transport.Domain.Department.TrafficChief;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface TrafficChiefRepository extends MainRepository<TrafficChief, String>
{
    ArrayList<TrafficChief> getAll();
}
