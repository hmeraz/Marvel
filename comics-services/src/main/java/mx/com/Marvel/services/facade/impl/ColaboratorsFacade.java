package mx.com.Marvel.services.facade.impl;

import mx.com.Marvel.commons.to.ColaboratorTO;
import mx.com.Marvel.services.facade.IColaboratorsFacade;
import mx.com.Marvel.services.service.IColaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ColaboratorsFacade implements IColaboratorsFacade {

    @Autowired
    private IColaboratorService colaboratorService;

    public ColaboratorTO getColaboratorsByHero(String hero) {
        return this.colaboratorService.getColaboratorByHero(hero);
    }
}
