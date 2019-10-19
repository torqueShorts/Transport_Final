package Transport.Repository.Repositories.DepartmentRepositories;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface TrafficDepartmentRepository extends MainRepository<TrafficDepartment, String>
{
    ArrayList<TrafficDepartment> getAll();
}
