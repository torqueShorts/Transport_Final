package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Trial;
import Transport.Service.ExternalServices.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Trial")

public class TrialController
{
    @Autowired
    @Qualifier("TrialServiceImpl")

    private TrialService service;


    @PostMapping("/create")
    @ResponseBody
    public Trial create(Trial trial)
    {
        return service.create(trial);
    }

    @PostMapping("/update")
    @ResponseBody
    public Trial update(Trial trial)
    {
        return service.update(trial);
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
    public ArrayList<Trial> getAll()
    {
        return service.getAll();
    }
}
