package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Trial;
import Transport.Repository.Impl.ExternalRepoImplementations.TrialRepositoryImpl;
import Transport.Repository.Repositories.ExternalRepositories.TrialRepository;
import Transport.Service.ExternalServices.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TrialServiceImpl")

public class TrialServiceImpl implements TrialService
{
    @Autowired
    @Qualifier("TrialRepo")

    private static TrialServiceImpl service = null;
    private TrialRepository repository;

    private TrialServiceImpl()
    {
        this.repository = TrialRepositoryImpl.getRepo();
    }

    public static TrialServiceImpl getService()
    {
        if(service == null)
        {
            service = new TrialServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<Trial> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Trial create(Trial type) {
        return this.repository.create(type);
    }

    @Override
    public Trial update(Trial type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Trial read(String s) {
        return this.repository.read(s);
    }
}
