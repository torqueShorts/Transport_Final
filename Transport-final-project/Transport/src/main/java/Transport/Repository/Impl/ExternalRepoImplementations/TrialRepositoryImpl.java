package Transport.Repository.Impl.ExternalRepoImplementations;

import Transport.Domain.External.Trial;
import Transport.Repository.Repositories.ExternalRepositories.TrialRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



public class TrialRepositoryImpl implements TrialRepository
{

    private static TrialRepositoryImpl repo;
    private ArrayList<Trial> trials;

    private TrialRepositoryImpl()
    {
        this.trials = new ArrayList<Trial>();
    }

    public static TrialRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new TrialRepositoryImpl();
        }

        return repo;
    }



    @Override
    public Trial create(Trial trial) {

        this.trials.add(trial);
        return trial;
    }

    @Override
    public Trial update(Trial trial)
    {
        int count = 1;

        Trial val = null;

        for(int i = 0; i < trials.size(); i++)
        {
            if(trials.get(i).getTrialID() == trial.getTrialID())
            {
                trials.set(i,trial);
                count--;
                System.out.println("Trial updated");
                val = trials.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Trial does not exist");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        Trial val = null;

        for(int i = 0; i < trials.size();i++)
        {
            if(trials.get(i).getTrialID().equalsIgnoreCase(obj))
            {
                trials.remove(i);
                count--;
                System.out.println("Trial deleted");
                val = trials.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Trial does not exist");
        }

    }

    @Override
    public Trial read(String obj)
    {
        int count = 1;

        Trial val = null;

        for(int i = 0; i < trials.size(); i++)
        {
            if(trials.get(i).getTrialID().equalsIgnoreCase(obj))
            {
                val = trials.get(i);
                count--;
                System.out.println("Trial read");
            }
        }

        if(count > 0)
        {
            System.out.println("Trial does not exist");
        }

        return val;
    }

    @Override
    public ArrayList<Trial> getAll()
    {
        return this.trials;
    }
}
