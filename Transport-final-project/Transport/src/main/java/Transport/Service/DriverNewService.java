package Transport.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Transport.Domain.DriverNew;
import Transport.Exception.RecordNotFoundException;
import Transport.Repository.Repositories.DriverNewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverNewService {

    @Autowired
    DriverNewRepo repository;

    public List<DriverNew> getAllEmployees()
    {
        List<DriverNew> result = (List<DriverNew>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<DriverNew>();
        }
    }

    public DriverNew getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<DriverNew> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public DriverNew createOrUpdateEmployee(DriverNew entity)
    {
        if(entity.getId()  == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<DriverNew> employee = repository.findById(entity.getId());

            if(employee.isPresent())
            {
                DriverNew newEntity = employee.get();
                newEntity.setPhoneNumber(entity.getPhoneNumber());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<DriverNew> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
