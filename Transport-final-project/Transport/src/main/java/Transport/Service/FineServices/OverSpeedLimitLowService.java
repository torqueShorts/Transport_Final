package Transport.Service.FineServices;

import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface OverSpeedLimitLowService extends MainService <OverSpeedLimitLow, String>
{
    ArrayList<OverSpeedLimitLow> getAll();
}
