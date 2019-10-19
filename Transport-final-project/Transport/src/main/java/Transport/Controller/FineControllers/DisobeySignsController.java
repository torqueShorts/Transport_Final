package Transport.Controller.FineControllers;

import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Service.FineServices.DisobeySignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/DisobeySigns")

public class DisobeySignsController
{
    @Autowired
    @Qualifier("DisobeySignServiceImpl")

    private DisobeySignService service;


    @PostMapping("/create")
    @ResponseBody
    public DisobeySigns create(DisobeySigns disobeySigns)
    {
        return service.create(disobeySigns);
    }

    @PostMapping("/update")
    @ResponseBody
    public DisobeySigns update(DisobeySigns disobeySigns)
    {
        return service.update(disobeySigns);
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
    public ArrayList<DisobeySigns> getAll()
    {
        return service.getAll();
    }
}
