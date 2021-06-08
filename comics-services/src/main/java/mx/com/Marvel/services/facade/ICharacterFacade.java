package mx.com.Marvel.services.facade;

import mx.com.Marvel.commons.to.CharacterTO;

import java.util.List;

public interface ICharacterFacade {
    CharacterTO getCharactersByHero(String hero);
}
