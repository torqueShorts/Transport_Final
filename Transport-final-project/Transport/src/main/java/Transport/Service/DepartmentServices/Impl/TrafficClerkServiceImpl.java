package Transport.Service.DepartmentServices.Impl;


import Transport.Domain.Department.TrafficClerk;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficClerkRepositoryImpl;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficClerkRepository;
import Transport.Service.DepartmentServices.TrafficChiefService;
import Transport.Service.DepartmentServices.TrafficClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TrafficClerkServiceImpl")


public class TrafficClerkServiceImpl implements TrafficClerkService
{

    @Autowired
    @Qualifier("TrafficClerkRepo")

    private static TrafficClerkServiceImpl service = null;
    private TrafficClerkRepositoryImpl repository;

    private TrafficClerkServiceImpl()
    {
        this.repository = TrafficClerkRepositoryImpl.getRepo();
    }

    public static TrafficClerkServiceImpl getService()
    {
        if(service == null)
        {
            service = new TrafficClerkServiceImpl();
        }
        return service;
    }




    @Override
    public ArrayList<TrafficClerk> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TrafficClerk create(TrafficClerk type) {
        return this.repository.create(type);
    }

    @Override
    public TrafficClerk update(TrafficClerk type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TrafficClerk read(String s) {
        return this.repository.read(s);
    }
}
