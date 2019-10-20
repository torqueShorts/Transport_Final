package Transport.Repository.Impl.DepartmentRepoImplementations;

import Transport.Domain.Department.TrafficChief;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficChiefRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public class TrafficChiefRepositoryImpl implements TrafficChiefRepository
{

    private static TrafficChiefRepositoryImpl repo;
    private ArrayList<TrafficChief> trafficChiefs;


    private TrafficChiefRepositoryImpl()
    {
        this.trafficChiefs = new ArrayList<TrafficChief>();
    }

    public static TrafficChiefRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new TrafficChiefRepositoryImpl();
        }
        return repo;
    }


    @Override
    public TrafficChief create(TrafficChief trafficChief) {

        this.trafficChiefs.add(trafficChief);
        return trafficChief;
    }

    @Override
    public TrafficChief update(TrafficChief trafficChief)
    {
        int count = 1;

        TrafficChief val = null;

        for(int i = 0; i < trafficChiefs.size(); i++)
        {
            if(trafficChiefs.get(i).getChiefID() == trafficChief.getChiefID())
            {
                trafficChiefs.set(i,trafficChief);
                count--;
                System.out.println("Traffic chief updated");
                val = trafficChiefs.get(i);

            }
        }

        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < trafficChiefs.size(); i++)
        {
            if(trafficChiefs.get(i).getChiefID().equalsIgnoreCase(obj))
            {
                trafficChiefs.remove(i);
                count--;
                System.out.println("traffic chief has been deleted");
            }
        }

        if(count > 0)
        {
            System.out.println("traffic chief does not exist");
        }

    }

    @Override
    public TrafficChief read(String obj)
    {
        int count = 1;

        TrafficChief val = null;

        for(int i = 0; i < trafficChiefs.size(); i++)
        {
            if(trafficChiefs.get(i).getChiefID().equalsIgnoreCase(obj))
            {
                val = trafficChiefs.get(i);
                count--;
                System.out.println("Chief read");
            }
        }

        if(count > 0)
        {
            System.out.println("Chief does not exist");
        }

        return val;
    }


    @Override
    public ArrayList<TrafficChief> getAll() {
        return trafficChiefs;
    }
}
