package Transport.Repository.Repositories.ExternalRepositories;

import Transport.Domain.External.Payment;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface PaymentRepository extends MainRepository<Payment, String>
{
    ArrayList<Payment> getAll();
}
