package Transport.Repository.Impl.DriverRepoImplementations;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.InternationalDriver;
import Transport.Repository.Repositories.DriverRepositories.InternationalDriverRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public class InternationalDriverRepositoryImpl implements InternationalDriverRepository
{

    private static InternationalDriverRepositoryImpl repo = null;
    private ArrayList<InternationalDriver> internationalDrivers;

    private InternationalDriverRepositoryImpl()
    {
        this.internationalDrivers = new ArrayList<InternationalDriver>();
    }

    public static InternationalDriverRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new InternationalDriverRepositoryImpl();
        }
        return repo;
    }


    @Override
    public InternationalDriver create(InternationalDriver driver)
    {
        this.internationalDrivers.add(driver);
        return driver;
    }

    @Override
    public InternationalDriver update(InternationalDriver driver)
    {
        int count = 1;

        InternationalDriver value = null;

        for(int i = 0; i < internationalDrivers.size();i++)
        {
            if(internationalDrivers.get(i).getDrive().getDriverID() == driver.getDrive().getDriverID())
            {
                internationalDrivers.set(i,driver);
                count--;
                System.out.println("International driver has been updated");
                value = internationalDrivers.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("International driver was not found");
        }

        return value;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < internationalDrivers.size(); i++)
        {
            if(internationalDrivers.get(i).getDrive().getDriverID().equalsIgnoreCase(obj))
            {
                internationalDrivers.remove(i);
                count--;
                System.out.println("Drivers " + obj + " has been removed");
            }

        }

        if(count > 0)
        {
            System.out.println("There is no Drivers with that ID");
        }


    }

    @Override
    public InternationalDriver read(String obj)
    {
        int count = 1;

        InternationalDriver value = null;

        for(int i = 0; i < internationalDrivers.size(); i++)
        {
            if(internationalDrivers.get(i).getDrive().getDriverID().equalsIgnoreCase(obj))
            {
                value = internationalDrivers.get(i);
                count--;
                System.out.println("Drivers recorded");
            }
        }

        if(count > 0)
        {
            System.out.println("Drivers not found");
        }

        return value;

    }

    @Override
    public ArrayList<InternationalDriver> getAll()
    {
        return this.internationalDrivers;
    }

}
