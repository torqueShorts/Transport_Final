package Transport.Repository.Repositories;

import Transport.Domain.DriverNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverNewRepo
        extends JpaRepository<DriverNew, Long> {

}
