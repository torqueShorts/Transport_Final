package Transport.Service.FineServices;

import Transport.Domain.Fines.Fine;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface FineService extends MainService<Fine, String>
{
    ArrayList<Fine> getAll();
}
