package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface MinorOffenceRepository extends MainRepository<MinorOffense, String>
{
    ArrayList<MinorOffense> getAll();


}
