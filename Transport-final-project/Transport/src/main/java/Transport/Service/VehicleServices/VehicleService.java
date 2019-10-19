package Transport.Service.VehicleServices;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface VehicleService extends MainService<Vehicle, String>
{
    ArrayList<Vehicle> getAll();
}