package mx.com.Marvel.services.facade.impl;

import mx.com.Marvel.commons.to.CharacterTO;
import mx.com.Marvel.services.facade.ICharacterFacade;
import mx.com.Marvel.services.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CharacterFacade implements ICharacterFacade {

    @Autowired
    private ICharacterService characterService;

    public  CharacterTO getCharactersByHero(String hero) {
        return this.characterService.getCharactersByHero(hero);
    }
}
