package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface OverSpeedLimitLowRepository extends MainRepository <OverSpeedLimitLow, String>
{
    ArrayList <OverSpeedLimitLow> getAll();
}
