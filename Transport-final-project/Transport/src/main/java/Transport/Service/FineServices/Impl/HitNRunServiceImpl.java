package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.HitNRunRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.HitNRunRepository;
import Transport.Service.FineServices.HitNRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("HitNRunServiceImpl")

public class HitNRunServiceImpl implements HitNRunService
{
    @Autowired
    @Qualifier("HitNRunRepo")

    private static HitNRunServiceImpl service = null;
    private HitNRunRepository repository;

    private HitNRunServiceImpl()
    {
        this.repository = HitNRunRepositoryImpl.getRepo();
    }

    public static HitNRunServiceImpl getService()
    {
        if(service == null)
        {
            service = new HitNRunServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<HitNRun> getAll() {
        return this.repository.getAll();
    }

    @Override
    public HitNRun create(HitNRun type) {
        return this.repository.create(type);
    }

    @Override
    public HitNRun update(HitNRun type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public HitNRun read(String s) {
        return this.repository.read(s);
    }
}
