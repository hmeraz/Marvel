package mx.com.Marvel.services.service.impl;

import mx.com.Marvel.commons.to.ColaboratorTO;
import mx.com.Marvel.model.ColaboratorDO;
import mx.com.Marvel.model.UpdatedDO;
import mx.com.Marvel.persistence.ColaboratorDAO;
import mx.com.Marvel.persistence.UpdatedDAO;
import mx.com.Marvel.services.service.IColaboratorService;
import mx.com.Marvel.commons.utils.CustomFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColaboratorServiceImpl implements IColaboratorService {

    static final Logger LOG = LogManager.getLogger(ColaboratorServiceImpl.class);

    @Autowired
    ColaboratorDAO colaboratorDAO;

    @Autowired
    UpdatedDAO updatedDAO;

    @Override
    public ColaboratorTO getColaboratorByHero(String hero) {
        ColaboratorTO colaboratorTO = new ColaboratorTO();

        List<ColaboratorDO> editors = this.colaboratorDAO.findByHeroAndType(hero, "editor");
        List<ColaboratorDO> writers = this.colaboratorDAO.findByHeroAndType(hero, "writer");
        List<ColaboratorDO> colorist = this.colaboratorDAO.findByHeroAndType(hero, "colorist");

        UpdatedDO updated = updatedDAO.findById(new Long(1)).get();
        colaboratorTO.setLast_sync(updated.getDate());

        colaboratorTO.setEditors(editors.stream().map(ColaboratorDO::getName).filter(CustomFunction.distinctByKey(p -> p)).collect(Collectors.toList()));
        colaboratorTO.setWriters(writers.stream().map(ColaboratorDO::getName).filter(CustomFunction.distinctByKey(p -> p)).collect(Collectors.toList()));
        colaboratorTO.setColorists(colorist.stream().map(ColaboratorDO::getName).filter(CustomFunction.distinctByKey(p -> p)).collect(Collectors.toList()));

        return colaboratorTO;
    }
}
