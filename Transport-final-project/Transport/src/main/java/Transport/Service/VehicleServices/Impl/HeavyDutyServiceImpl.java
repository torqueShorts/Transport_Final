package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Repository.Impl.VehicleRepoImplementations.HeavyDutyRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.HeavyDutyRepository;
import Transport.Service.VehicleServices.HeavyDutyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("HeavyDutyServiceImpl")

public class HeavyDutyServiceImpl implements HeavyDutyServices
{
    @Autowired
    @Qualifier("HeavyDutyRepo")

    private static HeavyDutyServiceImpl service = null;
    private HeavyDutyRepository repository;

    private HeavyDutyServiceImpl()
    {
        this.repository = HeavyDutyRepositoryImpl.getRepo();
    }

    public static HeavyDutyServiceImpl getService()
    {
        if(service == null)
        {
            service = new HeavyDutyServiceImpl();
        }
        return service;
    }



    @Override
    public ArrayList<HeavyDuty> getAll() {
        return this.repository.getAll();
    }

    @Override
    public HeavyDuty create(HeavyDuty type) {
        return this.repository.create(type);
    }

    @Override
    public HeavyDuty update(HeavyDuty type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public HeavyDuty read(String s) {
        return this.repository.read(s);
    }
}
