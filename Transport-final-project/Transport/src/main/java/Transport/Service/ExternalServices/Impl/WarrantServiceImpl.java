package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Warrant;
import Transport.Repository.Impl.ExternalRepoImplementations.WarrantRepositoryImpl;
import Transport.Repository.Repositories.ExternalRepositories.WarrantRepository;
import Transport.Service.ExternalServices.WarrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("WarrantServiceImpl")

public class WarrantServiceImpl implements WarrantService
{
    @Autowired
    @Qualifier("WarrantRepo")

    private static WarrantServiceImpl service = null;
    private WarrantRepository repository;

    private WarrantServiceImpl()
    {
        this.repository = WarrantRepositoryImpl.getRepo();
    }

    public static WarrantServiceImpl getService()
    {
        if(service == null)
        {
            service = new WarrantServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<Warrant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Warrant create(Warrant type) {
        return this.repository.create(type);
    }

    @Override
    public Warrant update(Warrant type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Warrant read(String s) {
        return this.repository.read(s);
    }
}
