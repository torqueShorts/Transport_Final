package Transport.Service.DepartmentServices;

import Transport.Domain.Department.TrafficChief;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface TrafficChiefService extends MainService <TrafficChief, String>
{
    ArrayList<TrafficChief> getAll();
}
