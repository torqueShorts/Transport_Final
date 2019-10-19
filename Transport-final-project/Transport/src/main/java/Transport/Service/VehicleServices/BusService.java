package Transport.Service.VehicleServices;

import Transport.Domain.Vehicles.Bus;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface BusService extends MainService <Bus, String>
{
    ArrayList<Bus> getAll();
}
