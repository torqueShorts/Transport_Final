package Transport.Service.VehicleServices;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface MotorbikeService extends MainService<Motorbike, String>
{
    ArrayList<Motorbike> getAll();
}
