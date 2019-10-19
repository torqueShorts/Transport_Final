package Transport.Service.DriverServices;

import Transport.Domain.Drivers.InternationalDriver;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface InternationalDriverService extends MainService <InternationalDriver, String>
{
    ArrayList<InternationalDriver> getAll();
}
