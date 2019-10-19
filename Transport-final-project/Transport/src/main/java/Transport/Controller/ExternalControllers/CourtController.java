package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Court;
import Transport.Service.ExternalServices.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Court")

public class CourtController
{
    @Autowired
    @Qualifier("CourtServiceImpl")

    private CourtService service;


    @PostMapping("/create")
    @ResponseBody
    public Court create(Court court)
    {
        return service.create(court);
    }

    @PostMapping("/update")
    @ResponseBody
    public Court update(Court court)
    {
        return service.update(court);
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
    public ArrayList<Court> getAll()
    {
        return service.getAll();
    }
}
