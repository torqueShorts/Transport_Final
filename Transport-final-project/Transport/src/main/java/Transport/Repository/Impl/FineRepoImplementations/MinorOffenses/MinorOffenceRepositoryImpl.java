package Transport.Repository.Impl.FineRepoImplementations.MinorOffenses;

import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Repository.Repositories.FineRepositories.MinorOffenceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public class MinorOffenceRepositoryImpl implements MinorOffenceRepository {

    private static MinorOffenceRepositoryImpl repo = null;
    private ArrayList<MinorOffense> minorFines;

    private MinorOffenceRepositoryImpl()
    {
        this.minorFines = new ArrayList<MinorOffense>();
    }

    public static MinorOffenceRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new MinorOffenceRepositoryImpl();
        }
        return repo;
    }


    @Override
    public MinorOffense create(MinorOffense minor)
    {
        this.minorFines.add(minor);
        return minor;
    }

    @Override
    public MinorOffense update(MinorOffense minor)
    {
        int count = 1;

        MinorOffense val = null;

        for(int i = 0; i < minorFines.size(); i++)
        {
            if(minorFines.get(i).getFine().getFineNum() == minor.getFine().getFineNum())
            {
                minorFines.set(i,minor);
                count--;
                System.out.println("Minor fine updated");
                val = minorFines.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Minor offence does not exist");
        }

        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;



        for(int i = 0; i < minorFines.size(); i++)
        {
            if(minorFines.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                minorFines.remove(i);
                count--;
                System.out.println("Minor fine has been removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Minor offence does not exist");
        }

    }

    @Override
    public MinorOffense read(String obj)
    {
        int count = 1;

        MinorOffense val = null;

        for(int i = 0; i < minorFines.size(); i++)
        {
            if(minorFines.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                val = minorFines.get(i);
                count--;
                System.out.println("Minor offence read");
            }
        }

        if(count > 0)
        {
            System.out.println("Minor offence does not exist");
        }

        return val;
    }

    @Override
    public ArrayList<MinorOffense> getAll()
    {
        return this.minorFines;
    }


}
