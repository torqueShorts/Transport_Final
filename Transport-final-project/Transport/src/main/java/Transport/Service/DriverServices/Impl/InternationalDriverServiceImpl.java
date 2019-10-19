package Transport.Service.DriverServices.Impl;

import Transport.Domain.Drivers.InternationalDriver;
import Transport.Repository.Impl.DriverRepoImplementations.InternationalDriverRepositoryImpl;
import Transport.Repository.Repositories.DriverRepositories.InternationalDriverRepository;
import Transport.Service.DriverServices.InternationalDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("InternationalDriverServiceImpl")



public class InternationalDriverServiceImpl implements InternationalDriverService
{

    @Autowired
    @Qualifier("InternationalDriverRepo")

    private static InternationalDriverServiceImpl service = null;
    private InternationalDriverRepository repository;

    private InternationalDriverServiceImpl()
    {
        this.repository = InternationalDriverRepositoryImpl.getRepo();
    }

    public static InternationalDriverServiceImpl getService()
    {
        if(service == null)
        {
            service = new InternationalDriverServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<InternationalDriver> getAll() {
        return this.repository.getAll();
    }

    @Override
    public InternationalDriver create(InternationalDriver type) {
        return this.repository.create(type);
    }

    @Override
    public InternationalDriver update(InternationalDriver type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public InternationalDriver read(String s) {
        return this.repository.read(s);
    }
}
