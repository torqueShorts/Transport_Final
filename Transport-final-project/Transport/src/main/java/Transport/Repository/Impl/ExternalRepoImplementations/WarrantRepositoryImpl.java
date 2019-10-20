package Transport.Repository.Impl.ExternalRepoImplementations;

import Transport.Domain.External.Warrant;
import Transport.Repository.Repositories.ExternalRepositories.WarrantRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class WarrantRepositoryImpl implements WarrantRepository {

    private static WarrantRepositoryImpl repo;
    private ArrayList<Warrant> warrants;

    private WarrantRepositoryImpl()
    {
        this.warrants = new ArrayList<Warrant>();
    }

    public static WarrantRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new WarrantRepositoryImpl();
        }
        return repo;
    }


    @Override
    public Warrant create(Warrant warrant)
    {
        this.warrants.add(warrant);
        return warrant;
    }

    @Override
    public Warrant update(Warrant warrant)
    {
        int count = 1;

        Warrant val = null;

        for(int i = 0; i < warrants.size(); i++)
        {
            if(warrants.get(i).getWarrantID() == warrant.getWarrantID())
            {
                warrants.set(i, warrant);
                count--;
                System.out.println("Warrant updated");
                val = warrants.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Warrant not found");
        }

        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < warrants.size(); i++)
        {
            if(warrants.get(i).getWarrantID().equalsIgnoreCase(obj))
            {
                warrants.remove(i);
                count--;
                System.out.println("Warrant deleted");
            }
        }

        if(count > 0)
        {
            System.out.println("Warrant not found");
        }

    }

    @Override
    public Warrant read(String obj)
    {
        int count = 1;

        Warrant val = null;

        for(int i = 0; i < warrants.size(); i++)
        {
            if(warrants.get(i).getWarrantID().equalsIgnoreCase(obj))
            {
                val = warrants.get(i);
                count--;
                System.out.println("Warrant recorded");
            }
        }

        if(count > 0)
        {
            System.out.println("Warrant was not found");
        }



        return val;
    }

    @Override
    public ArrayList<Warrant> getAll()
    {
        return this.warrants;
    }
}
