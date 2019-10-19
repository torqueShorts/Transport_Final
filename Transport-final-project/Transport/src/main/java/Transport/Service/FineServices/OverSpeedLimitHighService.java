package Transport.Service.FineServices;

import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface OverSpeedLimitHighService extends MainService <OverSpeedLimitHigh, String>
{
    ArrayList<OverSpeedLimitHigh> getAll();
}
