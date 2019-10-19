package Transport.Service.ExternalServices;

import Transport.Domain.External.Trial;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface TrialService extends MainService<Trial, String>
{
    ArrayList<Trial> getAll();
}
