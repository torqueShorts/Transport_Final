package Transport.Service.DepartmentServices;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface TrafficDepartmentService extends MainService <TrafficDepartment, String>
{
    ArrayList<TrafficDepartment> getAll();
}
