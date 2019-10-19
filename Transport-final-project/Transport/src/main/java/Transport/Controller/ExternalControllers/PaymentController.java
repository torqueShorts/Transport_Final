package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Payment;
import Transport.Service.ExternalServices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Payment")

public class PaymentController
{
    @Autowired
    @Qualifier("PaymentServiceImpl")

    private PaymentService service;


    @PostMapping("/create")
    @ResponseBody
    public Payment create(Payment payment)
    {
        return service.create(payment);
    }

    @PostMapping("/update")
    @ResponseBody
    public Payment update(Payment payment)
    {
        return service.update(payment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id)
    {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public void read(@PathVariable String id)
    {
        service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public ArrayList<Payment> getAll()
    {
        return service.getAll();
    }
}
