package Transport.Service.DriverServices.Impl;

import Transport.Domain.Drivers.NationalDriver;
import Transport.Repository.Impl.DriverRepoImplementations.NationalDriverRepositoryImpl;
import Transport.Repository.Repositories.DriverRepositories.NationalDriverRepository;
import Transport.Service.DriverServices.NationalDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("NationalDriverServiceImpl")

public class NationalDriverServiceImpl implements NationalDriverService
{
    @Autowired
    @Qualifier("NationalDriverRepo")

    private static NationalDriverServiceImpl service = null;
    private NationalDriverRepository repository;

    private NationalDriverServiceImpl()
    {
        this.repository = NationalDriverRepositoryImpl.getRepo();
    }

    public static NationalDriverServiceImpl getService()
    {
        if(service == null)
        {
            service = new NationalDriverServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<NationalDriver> getAll() {
        return this.repository.getAll();
    }

    @Override
    public NationalDriver create(NationalDriver type) {
        return this.repository.create(type);
    }

    @Override
    public NationalDriver update(NationalDriver type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public NationalDriver read(String s) {
        return this.repository.read(s);
    }
}
