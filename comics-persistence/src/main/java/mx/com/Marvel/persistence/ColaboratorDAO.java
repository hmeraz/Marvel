package mx.com.Marvel.persistence;

import mx.com.Marvel.model.ColaboratorDO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ColaboratorDAO extends CrudRepository<ColaboratorDO, Long> {

    List<ColaboratorDO> findByHeroAndType(String hero, String type);
}
