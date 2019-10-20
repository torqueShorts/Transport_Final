package Transport.Repository.Impl.FineRepoImplementations.MajorOffenses;

import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Repository.Repositories.FineRepositories.OverSpeedLimitHighRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class OverSpeedLimitHighRepositoryImpl implements OverSpeedLimitHighRepository
{

    private static OverSpeedLimitHighRepositoryImpl repo = null;
    private ArrayList<OverSpeedLimitHigh> overSpeedLimitHighs;

    private OverSpeedLimitHighRepositoryImpl()
    {
        this.overSpeedLimitHighs = new ArrayList<OverSpeedLimitHigh>();
    }

    public static OverSpeedLimitHighRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new OverSpeedLimitHighRepositoryImpl();
        }

        return repo;
    }


    @Override
    public OverSpeedLimitHigh create(OverSpeedLimitHigh overSpeedLimitHigh)
    {
        this.overSpeedLimitHighs.add(overSpeedLimitHigh);
        return overSpeedLimitHigh;
    }

    @Override
    public OverSpeedLimitHigh update(OverSpeedLimitHigh overSpeedLimitHigh)
    {
        int count = 1;

        OverSpeedLimitHigh val = null;

        for(int i = 0; i < overSpeedLimitHighs.size(); i++)
        {
            if(overSpeedLimitHighs.get(i).getFine().getFineNum() == overSpeedLimitHighs.get(i).getFine().getFineNum())
            {
                overSpeedLimitHighs.set(i,overSpeedLimitHigh);
                count--;
                val = overSpeedLimitHighs.get(i);
                System.out.println("fine updated");
            }
        }

        if(count > 0)
        {
            System.out.println("fine found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < overSpeedLimitHighs.size(); i++)
        {
            if(overSpeedLimitHighs.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                overSpeedLimitHighs.remove(i);
                count--;
                System.out.println("fine removed");
            }
        }

        if(count > 0)
        {
            System.out.println("fine not found");
        }


    }

    @Override
    public OverSpeedLimitHigh read(String obj)
    {

        int count = 1;

        OverSpeedLimitHigh val = null;

        for(int i = 0; i < overSpeedLimitHighs.size(); i++)
        {
            if(overSpeedLimitHighs.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                val = overSpeedLimitHighs.get(i);
                count--;
                System.out.println("fine read");
            }
        }

        if(count > 0)
        {
            System.out.println("fine not found");
        }


        return val;
    }

    @Override
    public ArrayList<OverSpeedLimitHigh> getAll()
    {
        return this.overSpeedLimitHighs;
    }
}
