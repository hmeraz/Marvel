package mx.com.Marvel.services.service.impl;

import mx.com.Marvel.commons.to.CharacterTO;
import mx.com.Marvel.commons.to.CharacterDetailTO;
import mx.com.Marvel.model.CharacterDO;
import mx.com.Marvel.model.UpdatedDO;
import mx.com.Marvel.persistence.CharacterDAO;
import mx.com.Marvel.persistence.UpdatedDAO;
import mx.com.Marvel.services.service.ICharacterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements ICharacterService {

    static final Logger LOG = LogManager.getLogger(CharacterServiceImpl.class);

    @Autowired
    CharacterDAO characterDAO;

    @Autowired
    UpdatedDAO updatedDAO;

    @Override
    public CharacterTO getCharactersByHero(String hero) {
        CharacterTO characterTO = new CharacterTO();
        UpdatedDO updated = updatedDAO.findById(new Long(1)).get();
        characterTO.setLast_sync(updated.getDate());
        List<CharacterDetailTO> details = new ArrayList<CharacterDetailTO>();

        List<CharacterDO> allCharacters = this.characterDAO.findByHero(hero);
        List<String> characteres = allCharacters.stream().map(CharacterDO::getCharacter).distinct().collect(Collectors.toList());

        for(String c:characteres) {
            List<CharacterDO> character = this.characterDAO.findByHeroAndCharacter(hero, c);
            CharacterDetailTO characterDetailTO = new CharacterDetailTO();
            characterDetailTO.setCharacter(c);
            characterDetailTO.setComics(character.stream().map(CharacterDO::getComic).collect(Collectors.toList()));
            details.add(characterDetailTO);
        }

        characterTO.setCharacters(details);
        return characterTO;
    }
}
