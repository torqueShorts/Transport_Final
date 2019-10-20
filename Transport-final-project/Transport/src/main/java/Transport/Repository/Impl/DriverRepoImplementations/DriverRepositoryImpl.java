package Transport.Repository.Impl.DriverRepoImplementations;

import Transport.Domain.Drivers.Driver;
import Transport.Repository.Repositories.DriverRepositories.DriverRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public class DriverRepositoryImpl implements DriverRepository
{

    private static DriverRepositoryImpl repo = null;
    private ArrayList<Driver> drivers;

    private DriverRepositoryImpl()
    {
        this.drivers = new ArrayList<Driver>();
    }

    public static DriverRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new DriverRepositoryImpl();
        }

        return repo;
    }


    public Driver create(Driver driver)
    {
        this.drivers.add(driver);
        return driver;
    }

    public Driver read(String driverID)
    {
        int count = 1;

        Driver value = null;

        for(int i = 0; i < drivers.size(); i++)
        {
            if(drivers.get(i).getDriverID().equalsIgnoreCase(driverID))
            {
                value = drivers.get(i);
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

    public void delete(String driverID)
    {
        int count = 1;

        for(int i = 0; i < drivers.size(); i++)
        {
            if(drivers.get(i).getDriverID().equalsIgnoreCase(driverID))
            {
                drivers.remove(i);
                count--;
                System.out.println("Drivers " + driverID + " has been removed");
            }

        }

        if(count > 0)
        {
            System.out.println("There is no Drivers with that ID");
        }


    }

    public Driver update(Driver driver)
    {
        int count = 1;

        Driver value = null;

        for(int i = 0; i < drivers.size();i++)
        {
            if(drivers.get(i).getDriverID() == driver.getDriverID())
            {
                drivers.set(i,driver);
                count--;
                System.out.println("Drivers has been updated");
                value = drivers.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Drivers was not found");
        }

        return value;
    }


    public ArrayList<Driver> getAll()
    {
        return this.drivers;
    }
}
