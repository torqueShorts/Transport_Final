package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface HitNRunRepository extends MainRepository <HitNRun, String>
{
    ArrayList<HitNRun> getAll();
}
