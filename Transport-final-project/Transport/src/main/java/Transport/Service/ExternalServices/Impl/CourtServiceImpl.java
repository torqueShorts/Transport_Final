package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Court;
import Transport.Repository.Impl.ExternalRepoImplementations.CourtRepositoryImpl;
import Transport.Repository.Repositories.ExternalRepositories.CourtRepository;
import Transport.Service.ExternalServices.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("CourtServiceImpl")

public class CourtServiceImpl implements CourtService
{

    @Autowired
    @Qualifier("CourtRepo")

    private static CourtServiceImpl service = null;
    private CourtRepository repository;

    private CourtServiceImpl()
    {
        this.repository = CourtRepositoryImpl.getRepo();
    }

    public static CourtServiceImpl getService()
    {
        if(service == null)
        {
            service = new CourtServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<Court> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Court create(Court type) {
        return this.repository.create(type);
    }

    @Override
    public Court update(Court type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Court read(String s) {
        return this.repository.read(s);
    }
}
