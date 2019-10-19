package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface OverSpeedLimitHighRepository extends MainRepository<OverSpeedLimitHigh,String>
{
    ArrayList<OverSpeedLimitHigh> getAll();
}
