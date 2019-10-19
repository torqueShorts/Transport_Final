package Transport.Repository.Repositories.VehicleRepositories;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Repository.Repositories.MainRepo.MainRepository;

import java.util.ArrayList;

public interface MotorbikeRepository extends MainRepository <Motorbike, String>
{
    ArrayList<Motorbike> getAll();
}
