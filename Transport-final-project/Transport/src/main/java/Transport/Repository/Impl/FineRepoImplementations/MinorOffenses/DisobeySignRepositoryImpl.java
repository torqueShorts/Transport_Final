package Transport.Repository.Impl.FineRepoImplementations.MinorOffenses;

import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Repository.Repositories.FineRepositories.DisobeySignRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class DisobeySignRepositoryImpl implements DisobeySignRepository
{

    private static DisobeySignRepositoryImpl repo = null;
    private ArrayList<DisobeySigns> disobeySigns;

    private DisobeySignRepositoryImpl()
    {
        this.disobeySigns = new ArrayList<DisobeySigns>();
    }

    public static DisobeySignRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new DisobeySignRepositoryImpl();
        }

        return repo;
    }




    @Override
    public DisobeySigns create(DisobeySigns disobeySign)
    {
        this.disobeySigns.add(disobeySign);
        return disobeySign;
    }

    @Override
    public DisobeySigns update(DisobeySigns disobeySign)
    {
        int count = 1;

        DisobeySigns val = null;

        for(int i = 0; i < disobeySigns.size(); i++)
        {
            if(disobeySigns.get(i).getFine().getFineNum() == disobeySign.getFine().getFineNum())
            {
                disobeySigns.set(i,disobeySign);
                count--;
                val = disobeySigns.get(i);
                System.out.println("DisobeySign Updated");
            }
        }

        if(count > 0)
        {
            System.out.println("Sign not found");
        }


        return val;

    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < disobeySigns.size(); i++)
        {
            if(disobeySigns.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                disobeySigns.remove(i);
                count--;
                System.out.println("removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Sign not found");
        }

    }

    @Override
    public DisobeySigns read(String obj)
    {
        int count = 1;

        DisobeySigns val = null;

        for(int i = 0; i < disobeySigns.size(); i++)
        {
            if(disobeySigns.get(i).getFine().getFineNum().equalsIgnoreCase(obj))
            {
                val = disobeySigns.get(i);
                count--;
                System.out.println("read");
            }
        }


        if(count > 0)
        {
            System.out.println("not found");
        }

        return val;
    }

    @Override
    public ArrayList<DisobeySigns> getAll()
    {
        return this.disobeySigns;
    }
}
