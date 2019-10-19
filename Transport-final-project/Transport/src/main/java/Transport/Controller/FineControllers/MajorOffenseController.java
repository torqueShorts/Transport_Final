package Transport.Controller.FineControllers;


import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Service.FineServices.MajorOffenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/MajorOffense")

public class MajorOffenseController
{
    @Autowired
    @Qualifier("MajorOffenseServiceImpl")

    private MajorOffenseService service;


    @PostMapping("/create")
    @ResponseBody
    public MajorOffense create(MajorOffense majorOffense)
    {
        return service.create(majorOffense);
    }

    @PostMapping("/update")
    @ResponseBody
    public MajorOffense update(MajorOffense majorOffense)
    {
        return service.update(majorOffense);
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
    public ArrayList<MajorOffense> getAll()
    {
        return service.getAll();
    }
}
