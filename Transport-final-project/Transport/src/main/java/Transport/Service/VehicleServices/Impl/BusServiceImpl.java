package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Bus;
import Transport.Repository.Impl.VehicleRepoImplementations.BusRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.BusRepository;
import Transport.Service.VehicleServices.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("BusServiceImpl")

public class BusServiceImpl implements BusService
{
    @Autowired
    @Qualifier("BusLowRepo")

    private static BusServiceImpl service = null;
    private BusRepository repository;

    private BusServiceImpl()
    {
        this.repository = BusRepositoryImpl.getRepo();
    }

    public static BusServiceImpl getService()
    {
        if(service == null)
        {
            service = new BusServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<Bus> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Bus create(Bus type) {
        return this.repository.create(type);
    }

    @Override
    public Bus update(Bus type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Bus read(String s) {
        return this.repository.read(s);
    }
}
