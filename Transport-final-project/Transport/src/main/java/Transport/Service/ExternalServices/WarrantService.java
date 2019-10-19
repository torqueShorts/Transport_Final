package Transport.Service.ExternalServices;

import Transport.Domain.External.Warrant;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface WarrantService extends MainService <Warrant, String>
{
    ArrayList<Warrant> getAll();
}
