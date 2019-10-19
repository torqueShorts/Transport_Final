package Transport.Service.DepartmentServices;

import Transport.Domain.Department.TrafficClerk;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface TrafficClerkService extends MainService <TrafficClerk, String>
{
    ArrayList<TrafficClerk> getAll();
}
