package Transport.Service.VehicleServices.Impl;

import Transport.Domain.Vehicles.Taxi;
import Transport.Repository.Impl.VehicleRepoImplementations.TaxiRepositoryImpl;
import Transport.Repository.Repositories.VehicleRepositories.TaxiRepository;
import Transport.Service.VehicleServices.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TaxiServiceImpl")

public class TaxiServiceImpl implements TaxiService
{
    @Autowired
    @Qualifier("TaxiRepo")

    private static TaxiServiceImpl service = null;
    private TaxiRepository repository;

    private TaxiServiceImpl()
    {
        this.repository = TaxiRepositoryImpl.getRepo();
    }

    public static TaxiServiceImpl getService()
    {
        if(service == null)
        {
            service = new TaxiServiceImpl();
        }
        return service;
    }

    @Override
    public ArrayList<Taxi> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Taxi create(Taxi type) {
        return this.repository.create(type);
    }

    @Override
    public Taxi update(Taxi type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Taxi read(String s) {
        return this.repository.read(s);
    }
}
