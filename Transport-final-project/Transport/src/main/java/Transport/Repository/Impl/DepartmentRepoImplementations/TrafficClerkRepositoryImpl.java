package Transport.Repository.Impl.DepartmentRepoImplementations;

import Transport.Domain.Department.TrafficClerk;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficClerkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository("TrafficClerkRepo")
public class TrafficClerkRepositoryImpl implements TrafficClerkRepository {


    private static TrafficClerkRepositoryImpl repo;
    private ArrayList<TrafficClerk> trafficClerks;

    private TrafficClerkRepositoryImpl()
    {
        this.trafficClerks = new ArrayList<TrafficClerk>();
    }

    public static TrafficClerkRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new TrafficClerkRepositoryImpl();
        }
        return repo;
    }

    @Override
    public TrafficClerk create(TrafficClerk clerk)
    {
        this.trafficClerks.add(clerk);
        return clerk;
    }

    @Override
    public TrafficClerk update(TrafficClerk trafficClerk)
    {
        int count = 1;
        TrafficClerk val = null;

        for(int i = 0; i < trafficClerks.size(); i++)
        {
            if(trafficClerks.get(i).getClerkID() == trafficClerk.getClerkID())
            {
                trafficClerks.set(i,trafficClerk);
                count--;
                System.out.println("Clerk updated");
                val = trafficClerks.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Clerk does not exist");
        }

        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < trafficClerks.size(); i++)
        {
            if(trafficClerks.get(i).getClerkID().equalsIgnoreCase(obj))
            {
                trafficClerks.remove(i);
                count--;
                System.out.println("Traffic clerk has been removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Traffic clerk was not found");
        }

    }

    @Override
    public TrafficClerk read(String obj)
    {
        int count = 1;

        TrafficClerk val = null;

        for(int i = 0; i < trafficClerks.size(); i++)
        {
            if(trafficClerks.get(i).getClerkID().equalsIgnoreCase(obj))
            {
                val = trafficClerks.get(i);
                count--;
                System.out.println("Clerk read");
            }
        }

        if(count > 0)
        {
            System.out.println("Clerk does not exist");
        }

        return val;
    }

    @Override
    public ArrayList<TrafficClerk> getAll()
    {
        return this.trafficClerks;
    }

}
