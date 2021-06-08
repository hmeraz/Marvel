package mx.com.Marvel.services.service.impl;

import mx.com.Marvel.commons.to.CharacterTO;
import mx.com.Marvel.commons.to.CharacterDetailTO;
import mx.com.Marvel.model.CharacterDO;
import mx.com.Marvel.model.ResultsDO;
import mx.com.Marvel.model.ItemsCreatorDO;
import mx.com.Marvel.model.ItemsCharacterDO;
import mx.com.Marvel.model.ColaboratorDO;
import mx.com.Marvel.model.ApiResponseDO;
import mx.com.Marvel.model.UpdatedDO;
import mx.com.Marvel.persistence.CharacterDAO;
import mx.com.Marvel.persistence.ColaboratorDAO;
import mx.com.Marvel.persistence.UpdatedDAO;
import mx.com.Marvel.services.service.IApiMarvelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiMarvelServiceImpl implements IApiMarvelService {

    static final Logger LOG = LogManager.getLogger(ApiMarvelServiceImpl.class);

    @Autowired
    CharacterDAO characterDAO;

    @Autowired
    ColaboratorDAO colaboratorDAO;

    @Autowired
    UpdatedDAO updatedDAO;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void sync() {
        List<String> comics = Arrays.asList("Iron Man", "Captain America");
        for(String comic : comics) {

            String urlIronman = "https://gateway.marvel.com/v1/public/comics?ts=1&apikey=d63b3ce11a4fadc53d3b2e09d1ae4f72&hash=fca3cfb706d1474aeaedf8b739174568&limit=50&titleStartsWith=" + comic;
            ApiResponseDO responseIronman = restTemplate.getForObject(urlIronman, ApiResponseDO.class);
            
            int count = responseIronman.getData().getTotal() / 50;
            LOG.info("Count "+ comic + " :" + count);
            for(int i = 0; i < count; i++)
            {
                ApiResponseDO responseIronmanOffset = restTemplate.getForObject(urlIronman + "&offset=" + i, ApiResponseDO.class);
                for(ResultsDO resultDO : responseIronmanOffset.getData().getResults()) {

                    for(ItemsCreatorDO creator : resultDO.getCreators().getItems()) {
                        ColaboratorDO colaborator = new ColaboratorDO();
                        colaborator.setHero(comic == "Iron Man" ? "ironman" : "capamerica");
                        colaborator.setType(creator.getRole());
                        colaborator.setName(creator.getName());
                        colaboratorDAO.save(colaborator);
                    }
    
                    for(ItemsCharacterDO characterDO : resultDO.getCharacters().getItems()) {
                        CharacterDO character = new CharacterDO();
                        character.setHero(comic == "Iron Man" ? "ironman" : "capamerica");
                        character.setCharacter(resultDO.getTitle());
                        character.setComic(characterDO.getName());
                        characterDAO.save(character);
                    }
                }
            }
        }

        UpdatedDO updated = updatedDAO.findById(new Long(1)).get();
        updated.setDate(LocalDateTime.now());
        updatedDAO.save(updated);
    }
}
