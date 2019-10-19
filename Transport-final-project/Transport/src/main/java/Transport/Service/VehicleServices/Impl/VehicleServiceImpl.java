package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Repository.Impl.VehicleRepoImplementations.VehicleRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.VehicleRepository;
import Transport.Service.VehicleServices.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("VehicleServiceImpl")

public class VehicleServiceImpl implements VehicleService
{
    @Autowired
    @Qualifier("VehicleRepo")

    private static VehicleServiceImpl service = null;
    private VehicleRepository repository;

    private VehicleServiceImpl()
    {
        this.repository = VehicleRepositoryImpl.getRepo();
    }

    public static VehicleServiceImpl getService()
    {
        if(service == null)
        {
            service = new VehicleServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Vehicle create(Vehicle type) {
        return this.repository.create(type);
    }

    @Override
    public Vehicle update(Vehicle type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Vehicle read(String s) {
        return this.repository.read(s);
    }
}
