package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface DisobeySignRepository extends MainRepository<DisobeySigns, String>
{
    ArrayList<DisobeySigns> getAll();

}
