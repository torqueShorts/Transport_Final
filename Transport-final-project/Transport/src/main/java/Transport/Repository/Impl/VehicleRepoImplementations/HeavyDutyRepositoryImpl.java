package Transport.Repository.Impl.VehicleRepoImplementations;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Repository.Repositories.VehicleRepositories.HeavyDutyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository("HeavyDutyRepo")
public class HeavyDutyRepositoryImpl implements HeavyDutyRepository
{

    private static HeavyDutyRepositoryImpl repo = null;
    private ArrayList<HeavyDuty> heavyDuties;

    private HeavyDutyRepositoryImpl()
    {
        this.heavyDuties = new ArrayList<>();
    }

    public static HeavyDutyRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new HeavyDutyRepositoryImpl();
        }
        return repo;
    }



    @Override
    public HeavyDuty create(HeavyDuty heavyDuty)
    {
        this.heavyDuties.add(heavyDuty);
        return heavyDuty;
    }

    @Override
    public HeavyDuty update(HeavyDuty heavyDuty)
    {
        int count = 1;

        HeavyDuty val = null;

        for(int i = 0; i < heavyDuties.size(); i++)
        {
            if(heavyDuties.get(i).getVeh().getVehicleLicense() == heavyDuty.getVeh().getVehicleLicense())
            {
                heavyDuties.set(i,heavyDuty);
                count--;
                val = heavyDuties.get(i);
                System.out.println("HeavyDuty updated");
            }
        }

        if(count > 0)
        {
            System.out.println("HeavyDuty not found");
        }


        return val;

    }

    @Override
    public void delete(String obj)
    {
        int count = 1;


        for(int i = 0; i < heavyDuties.size(); i++)
        {
            if(heavyDuties.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                heavyDuties.remove(i);
                count--;
                System.out.println("HeavyDuty removed");
            }
        }

        if(count > 0)
        {
            System.out.println("HeavyDuty not found");
        }

    }

    @Override
    public HeavyDuty read(String obj)
    {
        int count = 1;

        HeavyDuty val = null;

        for(int i = 0; i < heavyDuties.size(); i++)
        {
            if(heavyDuties.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                val = heavyDuties.get(i);
                count--;
                System.out.println("HeavyDuty read");
            }
        }

        if(count > 0)
        {
            System.out.println("HeavyDuty not found");
        }


        return val;
    }

    @Override
    public ArrayList<HeavyDuty> getAll()
    {
        return this.heavyDuties;
    }

}
