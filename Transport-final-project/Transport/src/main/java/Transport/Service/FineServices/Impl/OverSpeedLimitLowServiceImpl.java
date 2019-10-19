package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.OverSpeedLimitLowRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.OverSpeedLimitLowRepository;
import Transport.Service.FineServices.OverSpeedLimitLowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("OverSpeedLimitLowServiceImpl")

public class OverSpeedLimitLowServiceImpl implements OverSpeedLimitLowService
{
    @Autowired
    @Qualifier("OverSpeedLimitLowRepo")

    private static OverSpeedLimitLowServiceImpl service = null;
    private OverSpeedLimitLowRepository repository;

    private OverSpeedLimitLowServiceImpl()
    {
        this.repository = OverSpeedLimitLowRepositoryImpl.getRepo();
    }

    public static OverSpeedLimitLowServiceImpl getService()
    {
        if(service == null)
        {
            service = new OverSpeedLimitLowServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<OverSpeedLimitLow> getAll() {
        return this.repository.getAll();
    }


    @Override
    public OverSpeedLimitLow create(OverSpeedLimitLow type) {
        return this.repository.create(type);
    }

    @Override
    public OverSpeedLimitLow update(OverSpeedLimitLow type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public OverSpeedLimitLow read(String s) {
        return this.repository.read(s);
    }
}
