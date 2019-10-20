package Transport.Repository.Impl.ExternalRepoImplementations;

import Transport.Domain.External.Payment;
import Transport.Repository.Repositories.ExternalRepositories.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public class PaymentRepositoryImpl implements PaymentRepository {


    private static PaymentRepositoryImpl repo;
    private ArrayList<Payment> payments;

    private PaymentRepositoryImpl()
    {
        this.payments = new ArrayList<Payment>();
    }

    public static PaymentRepositoryImpl getRepo()
    {
        if(repo == null)
        {
            repo = new PaymentRepositoryImpl();
        }
        return repo;
    }


    @Override
    public Payment create(Payment payment)
    {
        this.payments.add(payment);
        return payment;
    }

    @Override
    public Payment update(Payment payment)
    {
        int count = 1;

        Payment val = null;

        for(int i = 0; i < payments.size();i++)
        {
            if(payments.get(i).getFineNum() == payment.getFineNum())
            {
                payments.set(i,payment);
                count--;
                System.out.println("Payment updated");
                val = payments.get(i);
            }
        }

        if(count > 0)
        {
            System.out.println("Payment not found");
        }


        return val;
    }

    @Override
    public void delete(String obj)
    {
        int count = 1;

        for(int i = 0; i < payments.size(); i++)
        {
            if(payments.get(i).getFineNum().equalsIgnoreCase(obj))
            {
                payments.remove(i);
                count--;
                System.out.println("Payment was removed");
            }
        }

        if(count > 0)
        {
            System.out.println("Payment was not found");
        }

    }

    @Override
    public Payment read(String obj)
    {
        int count = 1;

        Payment pay = null;

        for(int i = 0; i < payments.size(); i++)
        {
            if(payments.get(i).getDriverID().equalsIgnoreCase(obj))
            {
                pay = payments.get(i);
                count--;
                System.out.println("Payment read");
            }
        }

        if(count > 0)
        {
            System.out.println("Payment does not exist");
        }

        return pay;
    }

    @Override
    public ArrayList<Payment> getAll()
    {
        return this.payments;
    }
}
