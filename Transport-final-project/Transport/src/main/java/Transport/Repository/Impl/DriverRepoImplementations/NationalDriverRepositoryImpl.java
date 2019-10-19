package Transport.Repository.Impl.DriverRepoImplementations;

import Transport.Domain.Drivers.NationalDriver;
import Transport.Repository.Repositories.DriverRepositories.NationalDriverRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("NationalDriverRepo")

public class NationalDriverRepositoryImpl implements NationalDriverRepository
{

    private static NationalDriverRepositoryImpl repo = null;
    private ArrayList<NationalDriver> nationalDrivers;

    private NationalDriverRepositoryImpl()
    {
        this.nationalDrivers = new ArrayList<NationalDriver>();
    }

    public static NationalDriverRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new NationalDriverRepositoryImpl();
        }
        return repo;
    }

    @Override
    public NationalDriver create(NationalDriver driver)
    {
        this.nationalDrivers.add(driver);
        return driver;
    }

    @Override
    public NationalDriver update(NationalDriver driver)
    {
        int count = 1;

        NationalDriver value = null;

        for(int i = 0; i < nationalDrivers.size();i++)
        {
            if(nationalDrivers.get(i).getDrive().getDriverID() == driver.getDrive().getDriverID())
            {
                nationalDrivers.set(i,driver);
                count--;
                System.out.println("National driver has been updated");
                value = nationalDrivers.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("National driver was not found");
        }

        return value;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < nationalDrivers.size(); i++)
        {
            if(nationalDrivers.get(i).getDrive().getDriverID().equalsIgnoreCase(obj))
            {
                nationalDrivers.remove(i);
                count--;
                System.out.println("National driver " + obj + " has been removed");
            }

        }

        if(count > 0)
        {
            System.out.println("There is no nation driver with that ID");
        }

    }

    @Override
    public NationalDriver read(String obj)
    {
        int count = 1;

        NationalDriver value = null;

        for(int i = 0; i < nationalDrivers.size(); i++)
        {
            if(nationalDrivers.get(i).getDrive().getDriverID().equalsIgnoreCase(obj))
            {
                value = nationalDrivers.get(i);
                count--;
                System.out.println("National drivers recorded");
            }
        }

        if(count > 0)
        {
            System.out.println("National drivers not found");
        }

        return value;

    }

    @Override
    public ArrayList<NationalDriver> getAll()
    {
        return this.nationalDrivers;
    }

}
