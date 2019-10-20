package Transport.Repository.Impl.ExternalRepoImplementations;

import Transport.Domain.External.Verdict;
import Transport.Repository.Repositories.ExternalRepositories.VerdictRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public class VerdictRepositoryImpl implements VerdictRepository
{

    private static VerdictRepositoryImpl repo;
    private ArrayList<Verdict> verdicts;

    private VerdictRepositoryImpl()
    {
        this.verdicts = new ArrayList<Verdict>();
    }

    public static VerdictRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new VerdictRepositoryImpl();
        }
        return repo;
    }


    @Override
    public Verdict create(Verdict verdict)
    {
        this.verdicts.add(verdict);
        return verdict;
    }

    @Override
    public Verdict update(Verdict verdict)
    {
        int count = 1;

        Verdict val = null;

        for(int i = 0; i < verdicts.size(); i++)
        {
            if(verdicts.get(i).getFineNum() == verdict.getFineNum())
            {
                verdicts.set(i,verdict);
                count--;
                System.out.println("Verdict was updated");
                val = verdicts.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("verdict not found");
        }

        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < verdicts.size(); i++)
        {
            if(verdicts.get(i).getFineNum().equalsIgnoreCase(obj))
            {
                verdicts.remove(i);
                count--;
                System.out.println("verdict was removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Verdict was not found");
        }

    }

    @Override
    public Verdict read(String obj)
    {
        int count = 1;

        Verdict val = null;

        for(int i = 0; i < verdicts.size(); i++)
        {
            if(verdicts.get(i).getFineNum().equalsIgnoreCase(obj))
            {
                val = verdicts.get(i);
                count--;
                System.out.println("Verdict read");
            }
        }

        if(count > 0)
        {
            System.out.println("Verdict has not been found");
        }


        return val;
    }

    @Override
    public ArrayList<Verdict> getAll()
    {
        return this.verdicts;
    }
}
