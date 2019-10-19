package Transport.Repository.Repositories;

import Transport.Domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo
        extends CrudRepository<Employee, Long> {

}
