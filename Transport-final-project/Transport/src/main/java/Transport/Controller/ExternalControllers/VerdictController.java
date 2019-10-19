package Transport.Controller.ExternalControllers;

import Transport.Domain.External.Verdict;
import Transport.Service.ExternalServices.VerdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Verdict")

public class VerdictController
{
    @Autowired
    @Qualifier("VerdictServiceImpl")

    private VerdictService service;


    @PostMapping("/create")
    @ResponseBody
    public Verdict create(Verdict verdict)
    {
        return service.create(verdict);
    }

    @PostMapping("/update")
    @ResponseBody
    public Verdict update(Verdict verdict)
    {
        return service.update(verdict);
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
    public ArrayList<Verdict> getAll()
    {
        return service.getAll();
    }
}
