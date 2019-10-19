package Transport.Controller.FineControllers;

import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Service.FineServices.MinorOffenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/MinorOffense")

public class MinorOffenseController
{
    @Autowired
    @Qualifier("MinorOffenseServiceImpl")

    private MinorOffenseService service;


    @PostMapping("/create")
    @ResponseBody
    public MinorOffense create(MinorOffense minorOffense)
    {
        return service.create(minorOffense);
    }

    @PostMapping("/update")
    @ResponseBody
    public MinorOffense update(MinorOffense minorOffense)
    {
        return service.update(minorOffense);
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
    public ArrayList<MinorOffense> getAll()
    {
        return service.getAll();
    }
}
