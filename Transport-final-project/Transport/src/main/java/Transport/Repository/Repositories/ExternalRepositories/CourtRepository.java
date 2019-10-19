package Transport.Repository.Repositories.ExternalRepositories;

import Transport.Domain.External.Court;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface CourtRepository extends MainRepository <Court, String>
{
    ArrayList<Court> getAll();
}
