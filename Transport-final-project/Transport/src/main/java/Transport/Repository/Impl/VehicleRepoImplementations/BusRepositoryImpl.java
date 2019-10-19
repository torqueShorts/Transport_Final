package Transport.Repository.Impl.VehicleRepoImplementations;

import Transport.Domain.Vehicles.Bus;
import Transport.Repository.Repositories.VehicleRepositories.BusRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository("BusRepo")
public class BusRepositoryImpl implements BusRepository
{

    private static BusRepositoryImpl repo = null;
    private ArrayList<Bus> buses;

    private BusRepositoryImpl()
    {
        this.buses = new ArrayList<Bus>();
    }

    public static BusRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new BusRepositoryImpl();
        }
        return repo;
    }


    @Override
    public Bus create(Bus bus)
    {
        this.buses.add(bus);
        return bus;
    }

    @Override
    public Bus update(Bus bus)
    {
        int count = 1;

        Bus val = null;

        for(int i = 0; i < buses.size(); i++)
        {
            if(buses.get(i).getVeh().getVehicleLicense() == bus.getVeh().getVehicleLicense())
            {
                buses.set(i,bus);
                count--;
                val = buses.get(i);
                System.out.println("Bus updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Bus not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;


        for(int i = 0; i < buses.size(); i++)
        {
            if(buses.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                buses.remove(i);
                count--;
                System.out.println("Bus removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Bus not found");
        }

    }

    @Override
    public Bus read(String obj)
    {
        int count = 1;

        Bus val = null;

        for(int i = 0; i < buses.size(); i++)
        {
            if(buses.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                val = buses.get(i);
                count--;
                System.out.println("Bus read");
            }
        }

        if(count > 0)
        {
            System.out.println("Bus not found");
        }


        return val;
    }

    @Override
    public ArrayList<Bus> getAll() {
        return this.buses;
    }

}
