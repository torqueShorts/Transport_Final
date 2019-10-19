package Transport.Service.ExternalServices;

import Transport.Domain.External.Payment;
import Transport.Service.MainServ.MainService;

import java.util.ArrayList;

public interface PaymentService extends MainService <Payment, String>
{
    ArrayList<Payment> getAll();
}
