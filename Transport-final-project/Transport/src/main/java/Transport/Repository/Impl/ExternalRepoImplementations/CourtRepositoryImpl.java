package Transport.Repository.Impl.ExternalRepoImplementations;

import Transport.Domain.External.Court;
import Transport.Repository.Repositories.ExternalRepositories.CourtRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class CourtRepositoryImpl implements CourtRepository
{

    private static CourtRepositoryImpl repo;
    private ArrayList<Court> courts;

    private CourtRepositoryImpl()
    {
        this.courts = new ArrayList<Court>();
    }

    public static CourtRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new CourtRepositoryImpl();
        }
        return repo;
    }

    @Override
    public Court create(Court court)
    {
        this.courts.add(court);
        return court;
    }

    @Override
    public Court update(Court court)
    {
        int count = 1;

        Court val = null;

        for(int i = 0; i < courts.size();i++)
        {
            if(courts.get(i).getCourtName() == court.getCourtName())
            {
                courts.set(i,court);
                count--;
                System.out.println("Court updated");
                val = courts.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Court not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < courts.size(); i++)
        {
            if(courts.get(i).getCourtName().equalsIgnoreCase(obj))
            {
                courts.remove(i);
                count--;
                System.out.println("Court was removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Court was not found");
        }

    }

    @Override
    public Court read(String obj)
    {
        int count = 1;

        Court pay = null;

        for(int i = 0; i < courts.size(); i++)
        {
            if(courts.get(i).getCourtName().equalsIgnoreCase(obj))
            {
                pay = courts.get(i);
                count--;
                System.out.println("Court read");
            }
        }

        if(count > 0)
        {
            System.out.println("Court does not exist");
        }

        return pay;
    }

    @Override
    public ArrayList<Court> getAll()
    {
        return this.courts;
    }
}
