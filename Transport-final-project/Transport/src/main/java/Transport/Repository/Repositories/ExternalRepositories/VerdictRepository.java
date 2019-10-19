package Transport.Repository.Repositories.ExternalRepositories;

import Transport.Domain.External.Verdict;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface VerdictRepository extends MainRepository<Verdict, String>
{
    ArrayList<Verdict> getAll();
}
