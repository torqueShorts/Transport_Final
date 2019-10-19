package Transport.Repository.Impl.FineRepoImplementations.MajorOffenses;

import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Repository.Repositories.FineRepositories.HitNRunRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("HitNRunRepo")
public class HitNRunRepositoryImpl implements HitNRunRepository
{

    private static HitNRunRepositoryImpl repo = null;
    private ArrayList<HitNRun> hitNRuns;

    private HitNRunRepositoryImpl()
    {
        this.hitNRuns = new ArrayList<HitNRun>();
    }

    public static HitNRunRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new HitNRunRepositoryImpl();
        }
        return repo;
    }


    @Override
    public HitNRun create(HitNRun hitNRun)
    {
        this.hitNRuns.add(hitNRun);
        return hitNRun;
    }

    @Override
    public HitNRun update(HitNRun hitNRun)
    {
        int count = 1;

        HitNRun val = null;

        for(int i = 0; i < hitNRuns.size(); i++)
        {
            if(hitNRuns.get(i).getFine().getFineNum() == hitNRun.getFine().getFineNum())
            {
                hitNRuns.set(i,hitNRun);
                count--;
                val = hitNRuns.get(i);
                System.out.println("major offence updated");
            }
        }

        if(count > 0)
        {
            System.out.println("major offence not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < hitNRuns.size(); i++)
        {
            if(hitNRuns.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                hitNRuns.remove(i);
                count--;
                System.out.println("Major fine has been removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Major offence does not exist");
        }

    }

    @Override
    public HitNRun read(String obj)
    {
        int count = 1;

        HitNRun val = null;

        for(int i = 0; i < hitNRuns.size(); i++)
        {
            if(hitNRuns.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                val = hitNRuns.get(i);
                count--;
                System.out.println("major offence read");
            }
        }

        if(count > 0)
        {
            System.out.println("major offence not found");
        }


        return val;
    }

    @Override
    public ArrayList<HitNRun> getAll()
    {
        return this.hitNRuns;
    }

}
