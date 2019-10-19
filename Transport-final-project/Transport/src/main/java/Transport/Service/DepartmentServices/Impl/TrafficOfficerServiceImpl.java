package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficOfficer;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficOfficerRepositoryImpl;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficOfficerRepository;
import Transport.Service.DepartmentServices.TrafficOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TrafficOfficerServiceImpl")



public class TrafficOfficerServiceImpl implements TrafficOfficerService
{
    @Autowired
    @Qualifier("TrafficOfficerRepo")

    private static TrafficOfficerServiceImpl service = null;
    private TrafficOfficerRepository repository;

    private TrafficOfficerServiceImpl()
    {
        this.repository = TrafficOfficerRepositoryImpl.getRepo();
    }

    public static TrafficOfficerServiceImpl getService()
    {
        if(service == null)
        {
            service = new TrafficOfficerServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<TrafficOfficer> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TrafficOfficer create(TrafficOfficer type) {
        return this.repository.create(type);
    }

    @Override
    public TrafficOfficer update(TrafficOfficer type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TrafficOfficer read(String s) {
        return this.repository.read(s);
    }
}
