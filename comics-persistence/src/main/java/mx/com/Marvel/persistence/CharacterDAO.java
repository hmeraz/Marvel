package mx.com.Marvel.persistence;

import mx.com.Marvel.model.CharacterDO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CharacterDAO extends CrudRepository<CharacterDO, Long> {
    List<CharacterDO> findByHeroAndCharacter(String hero, String character);
    List<CharacterDO> findByHero(String hero);
}
