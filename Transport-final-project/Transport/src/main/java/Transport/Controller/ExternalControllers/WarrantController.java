package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Warrant;
import Transport.Service.ExternalServices.WarrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Warrant")

public class WarrantController
{
    @Autowired
    @Qualifier("WarrantServiceImpl")

    private WarrantService service;


    @PostMapping("/create")
    @ResponseBody
    public Warrant create(Warrant warrant)
    {
        return service.create(warrant);
    }

    @PostMapping("/update")
    @ResponseBody
    public Warrant update(Warrant warrant)
    {
        return service.update(warrant);
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
    public ArrayList<Warrant> getAll()
    {
        return service.getAll();
    }
}
