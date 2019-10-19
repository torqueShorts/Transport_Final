package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.MinorOffenceRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.MinorOffenceRepository;
import Transport.Service.FineServices.MinorOffenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("MinorOffenseServiceImpl")

public class MinorOffenseServiceImpl implements MinorOffenseService
{
    @Autowired
    @Qualifier("MinorOffenseRepo")

    private static MinorOffenseServiceImpl service = null;
    private MinorOffenceRepository repository;

    private MinorOffenseServiceImpl()
    {
        this.repository = MinorOffenceRepositoryImpl.getRepo();
    }

    public static MinorOffenseServiceImpl getService()
    {
        if(service == null)
        {
            service = new MinorOffenseServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<MinorOffense> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MinorOffense create(MinorOffense type) {
        return this.repository.create(type);
    }

    @Override
    public MinorOffense update(MinorOffense type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public MinorOffense read(String s) {
        return this.repository.read(s);
    }
}
