package Transport.Repository.Impl.VehicleRepoImplementations;

import Transport.Domain.Vehicles.Taxi;
import Transport.Repository.Repositories.VehicleRepositories.TaxiRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class TaxiRepositoryImpl implements TaxiRepository
{

    private static TaxiRepositoryImpl repo = null;
    private ArrayList<Taxi> taxis;

    private TaxiRepositoryImpl()
    {
        this.taxis = new ArrayList<>();
    }

    public static TaxiRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new TaxiRepositoryImpl();
        }
        return repo;
    }




    @Override
    public Taxi create(Taxi taxi)
    {
        this.taxis.add(taxi);
        return taxi;
    }

    @Override
    public Taxi update(Taxi taxi)
    {
        int count = 1;

        Taxi val = null;

        for(int i = 0; i < taxis.size(); i++)
        {
            if(taxis.get(i).getVeh().getVehicleLicense() == taxi.getVeh().getVehicleLicense())
            {
                taxis.set(i,taxi);
                count--;
                val = taxis.get(i);
                System.out.println("Taxi updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Taxi not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;


        for(int i = 0; i < taxis.size(); i++)
        {
            if(taxis.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                taxis.remove(i);
                count--;
                System.out.println("taxi removed");
            }
        }

        if(count > 0)
        {
            System.out.println("taxi not found");
        }

    }

    @Override
    public Taxi read(String obj)
    {
        int count = 1;

        Taxi val = null;

        for(int i = 0; i < taxis.size(); i++)
        {
            if(taxis.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                val = taxis.get(i);
                count--;
                System.out.println("Taxi read");
            }
        }

        if(count > 0)
        {
            System.out.println("Taxi not found");
        }


        return val;
    }

    @Override
    public ArrayList<Taxi> getAll()
    {
        return this.taxis;
    }


}
