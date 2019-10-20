package Transport.Controller;

import java.util.List;
import java.util.Optional;

import Transport.Domain.DriverNew;
import Transport.Exception.RecordNotFoundException;
import Transport.Service.DriverNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class DriverNewController
{
    @Autowired
    DriverNewService service;

    @RequestMapping
    public String getAllEmployees(Model model)
    {
        List<DriverNew> list = service.getAllEmployees();

        model.addAttribute("employees", list);
        return "driver-list";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            DriverNew entity = service.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new DriverNew());
        }
        return "create-driver";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(DriverNew employee)
    {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }
}

