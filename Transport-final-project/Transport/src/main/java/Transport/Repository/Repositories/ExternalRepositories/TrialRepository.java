package Transport.Repository.Repositories.ExternalRepositories;

import Transport.Domain.External.Trial;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface TrialRepository extends MainRepository<Trial,String>
{
    ArrayList<Trial> getAll();
}
