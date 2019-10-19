package Transport.Service.DriverServices;

import Transport.Domain.Drivers.Driver;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface DriverService extends MainService <Driver, String>
{
    ArrayList<Driver> getAll();
}
