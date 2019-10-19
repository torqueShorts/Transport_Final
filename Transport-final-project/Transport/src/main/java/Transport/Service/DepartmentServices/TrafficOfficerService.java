package Transport.Service.DepartmentServices;

import Transport.Domain.Department.TrafficOfficer;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface TrafficOfficerService extends MainService <TrafficOfficer, String>
{
    ArrayList<TrafficOfficer> getAll();
}
