package Transport.Controller.FineControllers;

import Transport.Domain.Fines.Fine;
import Transport.Service.FineServices.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Fine")

public class FineController
{
    @Autowired
    @Qualifier("FineServiceImpl")

    private FineService service;


    @PostMapping("/create")
    @ResponseBody
    public Fine create(Fine fine)
    {
        return service.create(fine);
    }

    @PostMapping("/update")
    @ResponseBody
    public Fine update(Fine fine)
    {
        return service.update(fine);
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
    public ArrayList<Fine> getAll()
    {
        return service.getAll();
    }
}
