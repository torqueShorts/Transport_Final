package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficChief;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficChiefRepositoryImpl;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficChiefRepository;
import Transport.Service.DepartmentServices.TrafficChiefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TrafficChiefServiceImpl")

public class TrafficChiefServiceImpl implements TrafficChiefService
{
    @Autowired
    @Qualifier("TrafficChiefRepo")

    private static TrafficChiefServiceImpl service = null;
    private TrafficChiefRepository repository;

    private TrafficChiefServiceImpl()
    {
        this.repository = TrafficChiefRepositoryImpl.getRepo();
    }

    public static TrafficChiefServiceImpl getService()
    {
        if(service == null)
        {
            service = new TrafficChiefServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<TrafficChief> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public TrafficChief create(TrafficChief trafficChief)
    {
        return this.repository.create(trafficChief);
    }

    @Override
    public TrafficChief update(TrafficChief trafficChief) {
        return this.repository.update(trafficChief);
    }

    @Override
    public void delete(String obj) {
        this.repository.delete(obj);
    }

    @Override
    public TrafficChief read(String obj) {
        return this.repository.read(obj);
    }
}
