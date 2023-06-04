package transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import transactions.model.Log;

public interface LogRepository extends JpaRepository<Log, Long>, LogRepositoryCustom {

}
