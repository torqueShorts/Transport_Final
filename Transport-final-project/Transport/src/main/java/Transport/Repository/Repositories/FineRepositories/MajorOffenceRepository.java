package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface MajorOffenceRepository extends MainRepository<MajorOffense, String>
{

    ArrayList<MajorOffense> getAll();

}
