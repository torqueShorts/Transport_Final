package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.DisobeySignRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.DisobeySignRepository;
import Transport.Service.FineServices.DisobeySignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("DisobeySignServiceImpl")

public class DisobeySignServiceImpl implements DisobeySignService
{
    @Autowired
    @Qualifier("DisobeySignRepo")

    private static DisobeySignServiceImpl service = null;
    private DisobeySignRepository repository;

    private DisobeySignServiceImpl()
    {
        this.repository = DisobeySignRepositoryImpl.getRepo();
    }

    public static DisobeySignServiceImpl getService()
    {
        if(service == null)
        {
            service = new DisobeySignServiceImpl();
        }
        return service;
    }


    @Override
    public ArrayList<DisobeySigns> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DisobeySigns create(DisobeySigns type) {
        return this.repository.create(type);
    }

    @Override
    public DisobeySigns update(DisobeySigns type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public DisobeySigns read(String s) {
        return this.repository.read(s);
    }
}
