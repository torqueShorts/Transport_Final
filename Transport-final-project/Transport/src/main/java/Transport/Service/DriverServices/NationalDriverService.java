package Transport.Service.DriverServices;

import Transport.Domain.Drivers.NationalDriver;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface NationalDriverService extends MainService <NationalDriver, String>
{
    ArrayList<NationalDriver> getAll();
}
