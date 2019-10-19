package Transport.Service.FineServices;

import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface MinorOffenseService extends MainService <MinorOffense, String>
{
    ArrayList<MinorOffense> getAll();
}
