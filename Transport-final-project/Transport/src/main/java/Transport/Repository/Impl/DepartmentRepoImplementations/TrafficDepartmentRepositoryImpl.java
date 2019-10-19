package Transport.Repository.Impl.DepartmentRepoImplementations;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficDepartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository("TrafficDepartmentRepo")
public class TrafficDepartmentRepositoryImpl implements TrafficDepartmentRepository
{

    private static TrafficDepartmentRepositoryImpl repo;
    private ArrayList<TrafficDepartment> trafficDepartments;

    private TrafficDepartmentRepositoryImpl()
    {
        this.trafficDepartments = new ArrayList<TrafficDepartment>();
    }


    public static TrafficDepartmentRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new TrafficDepartmentRepositoryImpl();
        }
        return repo;
    }


    @Override
    public TrafficDepartment create(TrafficDepartment department)
    {
        this.trafficDepartments.add(department);
        return department;
    }

    @Override
    public TrafficDepartment update(TrafficDepartment department)
    {
        int count = 1;
        TrafficDepartment val = null;

        for(int i = 0; i < trafficDepartments.size(); i++)
        {
            if(trafficDepartments.get(i).getDeptCode() == department.getDeptCode())
            {
                trafficDepartments.set(i,department);
                count--;
                System.out.println("Department updated");
                val = trafficDepartments.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Department does not exist");
        }

        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < trafficDepartments.size(); i++)
        {
            if(trafficDepartments.get(i).getDeptCode().equalsIgnoreCase(obj))
            {
                trafficDepartments.remove(i);
                count--;
                System.out.println("Traffic department has been removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Traffic department was not found");
        }
    }

    @Override
    public TrafficDepartment read(String obj)
    {
        int count = 1;

        TrafficDepartment val = null;

        for(int i = 0; i < trafficDepartments.size(); i++)
        {
            if(trafficDepartments.get(i).getDeptCode().equalsIgnoreCase(obj))
            {
                val = trafficDepartments.get(i);
                count--;
                System.out.println("Department read");
            }
        }

        if(count > 0)
        {
            System.out.println("Department does not exist");
        }

        return val;
    }

    @Override
    public ArrayList<TrafficDepartment> getAll()
    {
        return this.trafficDepartments;
    }

}
