package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.MajorOffenceRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.MajorOffenceRepository;
import Transport.Service.FineServices.MajorOffenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("MajorOffenseServiceImpl")

public class MajorOffenseServiceImpl implements MajorOffenseService
{
    @Autowired
    @Qualifier("MajorOffenseRepo")

    private static MajorOffenseServiceImpl service = null;
    private MajorOffenceRepository repository;

    private MajorOffenseServiceImpl()
    {
        this.repository = MajorOffenceRepositoryImpl.getRepo();
    }

    public static MajorOffenseServiceImpl getService()
    {
        if(service == null)
        {
            service = new MajorOffenseServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<MajorOffense> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MajorOffense create(MajorOffense type) {
        return this.repository.create(type);
    }

    @Override
    public MajorOffense update(MajorOffense type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public MajorOffense read(String s) {
        return this.repository.read(s);
    }
}
