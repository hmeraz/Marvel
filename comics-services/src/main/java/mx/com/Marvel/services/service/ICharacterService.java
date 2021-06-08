package mx.com.Marvel.services.service;

import mx.com.Marvel.commons.to.CharacterTO;

public interface ICharacterService {
	CharacterTO getCharactersByHero(String hero);
}
