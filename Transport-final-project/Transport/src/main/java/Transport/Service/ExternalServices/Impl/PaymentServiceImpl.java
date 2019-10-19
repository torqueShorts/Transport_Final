package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Payment;
import Transport.Repository.Impl.ExternalRepoImplementations.PaymentRepositoryImpl;
import Transport.Repository.Repositories.ExternalRepositories.PaymentRepository;
import Transport.Service.ExternalServices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("PaymentServiceImpl")

public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    @Qualifier("PaymentRepo")

    private static PaymentServiceImpl service = null;
    private PaymentRepository repository;

    private PaymentServiceImpl()
    {
        this.repository = PaymentRepositoryImpl.getRepo();
    }

    public static PaymentServiceImpl getService()
    {
        if(service == null)
        {
            service = new PaymentServiceImpl();
        }
        return service;
    }



    @Override
    public ArrayList<Payment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Payment create(Payment type) {
        return this.repository.create(type);
    }

    @Override
    public Payment update(Payment type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.delete(s);
    }

    @Override
    public Payment read(String s) {
        return this.repository.read(s);
    }
}
