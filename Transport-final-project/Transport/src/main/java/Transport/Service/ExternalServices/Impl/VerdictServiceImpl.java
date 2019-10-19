package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Verdict;
import Transport.Repository.Impl.ExternalRepoImplementations.VerdictRepositoryImpl;
import Transport.Repository.Repositories.ExternalRepositories.VerdictRepository;
import Transport.Service.ExternalServices.VerdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("VerdictServiceImpl")

public class VerdictServiceImpl implements VerdictService
{
    @Autowired
    @Qualifier("VerdictRepo")

    private static VerdictServiceImpl service = null;
    private VerdictRepository repository;

    private VerdictServiceImpl()
    {
        this.repository = VerdictRepositoryImpl.getRepo();
    }

    public static VerdictServiceImpl getService()
    {
        if(service == null)
        {
            service = new VerdictServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<Verdict> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Verdict create(Verdict type) {
        return this.repository.create(type);
    }

    @Override
    public Verdict update(Verdict type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Verdict read(String s) {
        return this.repository.read(s);
    }
}
