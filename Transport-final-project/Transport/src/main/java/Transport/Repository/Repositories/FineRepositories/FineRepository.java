package Transport.Repository.Repositories.FineRepositories;

import Transport.Domain.Fines.Fine;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface FineRepository extends MainRepository<Fine, String>
{
    ArrayList<Fine> getAll();
}
