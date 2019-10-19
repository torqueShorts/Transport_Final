package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.OverSpeedLimitHighRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.OverSpeedLimitHighRepository;
import Transport.Service.FineServices.OverSpeedLimitHighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("OverSpeedLimitHighServiceImpl")

public class OverSpeedLimitHighServiceImpl implements OverSpeedLimitHighService
{
    @Autowired
    @Qualifier("OverSpeedLimitLowRepo")

    private static OverSpeedLimitHighServiceImpl service = null;
    private OverSpeedLimitHighRepository repository;

    private OverSpeedLimitHighServiceImpl()
    {
        this.repository = OverSpeedLimitHighRepositoryImpl.getRepo();
    }

    public static OverSpeedLimitHighServiceImpl getService()
    {
        if(service == null)
        {
            service = new OverSpeedLimitHighServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<OverSpeedLimitHigh> getAll() {
        return this.repository.getAll();
    }

    @Override
    public OverSpeedLimitHigh create(OverSpeedLimitHigh type) {
        return this.repository.create(type);
    }

    @Override
    public OverSpeedLimitHigh update(OverSpeedLimitHigh type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public OverSpeedLimitHigh read(String s) {
        return this.repository.read(s);
    }
}
