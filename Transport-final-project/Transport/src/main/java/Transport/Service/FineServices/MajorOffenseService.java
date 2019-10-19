package Transport.Service.FineServices;

import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface MajorOffenseService extends MainService <MajorOffense, String>
{
    ArrayList<MajorOffense> getAll();
}
