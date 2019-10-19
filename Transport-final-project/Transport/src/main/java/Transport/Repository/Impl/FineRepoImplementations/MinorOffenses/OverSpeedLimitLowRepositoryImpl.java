package Transport.Repository.Impl.FineRepoImplementations.MinorOffenses;

import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Repository.Repositories.FineRepositories.OverSpeedLimitLowRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository("OverSpeedLimitLowRepo")
public class OverSpeedLimitLowRepositoryImpl implements OverSpeedLimitLowRepository
{

    private static OverSpeedLimitLowRepositoryImpl repo = null;
    private ArrayList<OverSpeedLimitLow> overSpeedLimitLows;

    private OverSpeedLimitLowRepositoryImpl()
    {
        this.overSpeedLimitLows = new ArrayList<OverSpeedLimitLow>();
    }

    public static OverSpeedLimitLowRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new OverSpeedLimitLowRepositoryImpl();
        }
        return repo;
    }


    @Override
    public OverSpeedLimitLow create(OverSpeedLimitLow over)
    {
        this.overSpeedLimitLows.add(over);
        return over;
    }

    @Override
    public OverSpeedLimitLow update(OverSpeedLimitLow over)
    {
        int count = 1;

        OverSpeedLimitLow val = null;

        for(int i = 0; i < overSpeedLimitLows.size(); i++)
        {
            if(overSpeedLimitLows.get(i).getFine().getFineNum() == overSpeedLimitLows.get(i).getFine().getFineNum())
            {
                overSpeedLimitLows.set(i,over);
                count--;
                val = overSpeedLimitLows.get(i);
                System.out.println("Fine updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Fine found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < overSpeedLimitLows.size(); i++)
        {
            if(overSpeedLimitLows.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                overSpeedLimitLows.remove(i);
                count--;
                System.out.println("Fine removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Fine not found");
        }


    }

    @Override
    public OverSpeedLimitLow read(String obj)
    {
        int count = 1;

        OverSpeedLimitLow val = null;

        for(int i = 0; i < overSpeedLimitLows.size(); i++)
        {
            if(overSpeedLimitLows.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                val = overSpeedLimitLows.get(i);
                count--;
                System.out.println("Fine read");
            }
        }

        if(count > 0)
        {
            System.out.println("Fine not found");
        }


        return val;
    }


    @Override
    public ArrayList<OverSpeedLimitLow> getAll()
    {
        return this.overSpeedLimitLows;
    }

}
