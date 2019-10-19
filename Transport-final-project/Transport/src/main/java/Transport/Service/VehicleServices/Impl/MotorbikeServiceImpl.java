package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Repository.Impl.VehicleRepoImplementations.MotorbikeRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.MotorbikeRepository;
import Transport.Service.VehicleServices.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("MotorbikeServiceImpl")

public class MotorbikeServiceImpl implements MotorbikeService
{
    @Autowired
    @Qualifier("MototbikeRepo")

    private static MotorbikeServiceImpl service = null;
    private MotorbikeRepository repository;

    private MotorbikeServiceImpl()
    {
        this.repository = MotorbikeRepositoryImpl.getRepo();
    }

    public static MotorbikeServiceImpl getService()
    {
        if(service == null)
        {
            service = new MotorbikeServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<Motorbike> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Motorbike create(Motorbike type) {
        return this.repository.create(type);
    }

    @Override
    public Motorbike update(Motorbike type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Motorbike read(String s) {
        return this.repository.read(s);
    }
}
