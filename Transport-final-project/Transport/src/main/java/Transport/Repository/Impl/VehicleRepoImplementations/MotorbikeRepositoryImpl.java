package Transport.Repository.Impl.VehicleRepoImplementations;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Repository.Repositories.VehicleRepositories.MotorbikeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository("MotorbikeRepo")
public class MotorbikeRepositoryImpl implements MotorbikeRepository
{
    private static MotorbikeRepositoryImpl repo = null;
    private ArrayList<Motorbike> motorbikes;

    private MotorbikeRepositoryImpl()
    {
        this.motorbikes = new ArrayList<>();
    }

    public static MotorbikeRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new MotorbikeRepositoryImpl();
        }
        return repo;
    }

    @Override
    public Motorbike create(Motorbike motorbike)
    {
        this.motorbikes.add(motorbike);
        return motorbike;
    }

    @Override
    public Motorbike update(Motorbike motorbike)
    {
        int count = 1;

        Motorbike val = null;

        for(int i = 0; i < motorbikes.size(); i++)
        {
            if(motorbikes.get(i).getVeh().getVehicleLicense() == motorbike.getVeh().getVehicleLicense())
            {
                motorbikes.set(i,motorbike);
                count--;
                val = motorbikes.get(i);
                System.out.println("Motorbike updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Motorbike not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;


        for(int i = 0; i < motorbikes.size(); i++)
        {
            if(motorbikes.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                motorbikes.remove(i);
                count--;
                System.out.println("motorbikes removed");
            }
        }

        if(count > 0)
        {
            System.out.println("motorbikes not found");
        }

    }

    @Override
    public Motorbike read(String obj)
    {
        int count = 1;

        Motorbike val = null;

        for(int i = 0; i < motorbikes.size(); i++)
        {
            if(motorbikes.get(i).getVeh().getVehicleLicense().equalsIgnoreCase(obj))
            {
                val = motorbikes.get(i);
                count--;
                System.out.println("Motorbikes read");
            }
        }

        if(count > 0)
        {
            System.out.println("Motorbikes not found");
        }


        return val;
    }

    @Override
    public ArrayList<Motorbike> getAll()
    {
        return this.motorbikes;
    }
}
