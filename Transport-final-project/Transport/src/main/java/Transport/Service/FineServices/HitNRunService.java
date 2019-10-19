package Transport.Service.FineServices;

import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface HitNRunService extends MainService <HitNRun, String>
{
    ArrayList<HitNRun> getAll();
}
