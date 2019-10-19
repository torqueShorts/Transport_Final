package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficDepartmentRepositoryImpl;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficDepartmentRepository;
import Transport.Service.DepartmentServices.TrafficDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TrafficDepartmentServiceImpl")



public class TrafficDepartmentServiceImpl implements TrafficDepartmentService
{
    @Autowired
    @Qualifier("TrafficDepartmentRepo")

    private static TrafficDepartmentServiceImpl service = null;
    private TrafficDepartmentRepository repository;

    private TrafficDepartmentServiceImpl()
    {
        this.repository = TrafficDepartmentRepositoryImpl.getRepo();
    }

    public static TrafficDepartmentServiceImpl getService()
    {
        if(service == null)
        {
            service = new TrafficDepartmentServiceImpl();
        }
        return service;
    }



    @Override
    public ArrayList<TrafficDepartment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TrafficDepartment create(TrafficDepartment type) {
        return this.repository.create(type);
    }

    @Override
    public TrafficDepartment update(TrafficDepartment type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TrafficDepartment read(String s) {
        return this.repository.read(s);
    }
}
