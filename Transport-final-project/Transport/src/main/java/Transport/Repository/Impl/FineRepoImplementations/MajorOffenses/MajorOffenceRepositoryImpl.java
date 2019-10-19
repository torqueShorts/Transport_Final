package Transport.Repository.Impl.FineRepoImplementations.MajorOffenses;

import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Repository.Repositories.FineRepositories.MajorOffenceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("MajorOffenseRepo")
public class MajorOffenceRepositoryImpl implements MajorOffenceRepository
{

    private static MajorOffenceRepositoryImpl repo = null;
    private ArrayList<MajorOffense> majorOffenses;

    private MajorOffenceRepositoryImpl()
    {
        this.majorOffenses = new ArrayList<MajorOffense>();
    }

    public static MajorOffenceRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new MajorOffenceRepositoryImpl();
        }

        return repo;
    }


    @Override
    public MajorOffense create(MajorOffense majorOffense)
    {
        this.majorOffenses.add(majorOffense);
        return majorOffense;
    }

    @Override
    public MajorOffense update(MajorOffense majorOffense)
    {
        int count = 1;

        MajorOffense val = null;

        for(int i = 0; i < majorOffenses.size(); i++)
        {
            if(majorOffenses.get(i).getFine().getFineNum() == majorOffense.getFine().getFineNum())
            {
                majorOffenses.set(i,majorOffense);
                count--;
                val = majorOffenses.get(i);
                System.out.println("Major offence updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Major offence not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;


        for(int i = 0; i < majorOffenses.size(); i++)
        {
            if(majorOffenses.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                majorOffenses.remove(i);
                count--;
                System.out.println("Major offence removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Major offence not found");
        }

    }

    @Override
    public MajorOffense read(String obj)
    {
        int count = 1;

        MajorOffense val = null;

        for(int i = 0; i < majorOffenses.size(); i++)
        {
            if(majorOffenses.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                val = majorOffenses.get(i);
                count--;
                System.out.println("Major offence read");
            }
        }

        if(count > 0)
        {
            System.out.println("Major offence not found");
        }


        return val;
    }


    @Override
    public ArrayList<MajorOffense> getAll()
    {
        return this.majorOffenses;
    }

}
