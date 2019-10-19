package Transport.Repository.Repositories.ExternalRepositories;

import Transport.Domain.External.Warrant;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface WarrantRepository extends MainRepository<Warrant, String>
{
    ArrayList<Warrant> getAll();
}

