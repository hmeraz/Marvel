package mx.com.Marvel.services.facade;

import mx.com.Marvel.commons.to.ColaboratorTO;

import java.util.List;

public interface IColaboratorsFacade {
    ColaboratorTO getColaboratorsByHero(String hero);
}
