package Transport.Service.VehicleServices;

import Transport.Domain.Vehicles.Car;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface CarService extends MainService<Car, String>
{
    ArrayList<Car> getAll();
}
