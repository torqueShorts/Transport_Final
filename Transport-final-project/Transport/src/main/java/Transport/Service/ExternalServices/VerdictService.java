package Transport.Service.ExternalServices;

import Transport.Domain.External.Verdict;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface VerdictService extends MainService<Verdict, String>
{
    ArrayList<Verdict> getAll();
}
