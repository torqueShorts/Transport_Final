package Transport.Service.DriverServices.Impl;

import Transport.Domain.Drivers.Driver;
import Transport.Repository.Impl.DriverRepoImplementations.DriverRepositoryImpl;
import Transport.Repository.Repositories.DriverRepositories.DriverRepository;
import Transport.Service.DriverServices.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("DriverServiceImpl")

public class DriverServiceImpl implements DriverService
{
    @Autowired
    @Qualifier("DriverRepo")

    private static DriverServiceImpl service = null;
    private DriverRepository repository;

    private DriverServiceImpl()
    {
        this.repository = DriverRepositoryImpl.getRepo();
    }

    public static DriverServiceImpl getService()
    {
        if(service == null)
        {
            service = new DriverServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<Driver> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Driver create(Driver type) {
        return this.repository.create(type);
    }

    @Override
    public Driver update(Driver type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Driver read(String s) {
        return this.repository.read(s);
    }
}
