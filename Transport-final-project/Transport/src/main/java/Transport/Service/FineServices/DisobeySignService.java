package Transport.Service.FineServices;

import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface DisobeySignService extends MainService<DisobeySigns, String>
{
    ArrayList<DisobeySigns> getAll();
}
