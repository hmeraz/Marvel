package mx.com.Marvel.persistence;

import mx.com.Marvel.model.UpdatedDO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UpdatedDAO extends CrudRepository<UpdatedDO, Long> {
}
