package Transport.Service.VehicleServices;

import Transport.Domain.Vehicles.Taxi;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface TaxiService extends MainService<Taxi, String>
{
    ArrayList<Taxi> getAll();
}
