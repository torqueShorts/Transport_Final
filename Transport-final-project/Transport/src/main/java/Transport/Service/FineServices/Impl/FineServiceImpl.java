package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Repository.Impl.FineRepoImplementations.FineRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.FineRepository;
import Transport.Service.FineServices.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("FineServiceImpl")

public class FineServiceImpl implements FineService
{
    @Autowired
    @Qualifier("FineRepo")

    private static FineServiceImpl service = null;
    private FineRepository repository;

    private FineServiceImpl()
    {
        this.repository = FineRepositoryImpl.getRepo();
    }

    public static FineServiceImpl getService()
    {
        if(service == null)
        {
            service = new FineServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<Fine> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Fine create(Fine type) {
        return this.repository.create(type);
    }

    @Override
    public Fine update(Fine type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Fine read(String s) {
        return this.repository.read(s);
    }
}
