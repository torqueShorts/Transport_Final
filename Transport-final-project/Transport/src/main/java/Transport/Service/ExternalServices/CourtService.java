package Transport.Service.ExternalServices;

import Transport.Domain.External.Court;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface CourtService extends MainService <Court, String>
{
    ArrayList<Court> getAll();
}
