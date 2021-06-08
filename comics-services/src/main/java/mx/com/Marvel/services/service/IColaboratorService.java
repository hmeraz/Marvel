package mx.com.Marvel.services.service;

import mx.com.Marvel.commons.to.ColaboratorTO;

public interface IColaboratorService {
	ColaboratorTO getColaboratorByHero(String hero);
}