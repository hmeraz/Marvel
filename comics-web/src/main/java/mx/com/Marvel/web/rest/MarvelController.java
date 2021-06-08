package mx.com.Marvel.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.Marvel.commons.to.ColaboratorTO;
import mx.com.Marvel.commons.to.CharacterTO;
import mx.com.Marvel.services.facade.IColaboratorsFacade;
import mx.com.Marvel.services.facade.ICharacterFacade;
import mx.com.Marvel.services.facade.ISyncFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("marvel")
@Api(value="marvel")
public class MarvelController {

    static final Logger LOG = LogManager.getLogger(MarvelController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IColaboratorsFacade colaboratorsFacade;

    @Autowired
    ICharacterFacade characterFacade;

    @Autowired
    ISyncFacade syncFacade;

    @GetMapping(value = "/colaborators/{hero}", produces = "application/json")
    @ApiOperation(value = "Buscar Colaboradores",
            notes = "Obtendremos los editores, escritores y coloristas que han estado involucrados en los cómics del personaje.",
            response = ColaboratorTO.class,
            produces = "application/json")
    public ResponseEntity<ColaboratorTO> getAllColaborators(@PathVariable("hero") String hero) {
        ColaboratorTO colaborators = this.colaboratorsFacade.getColaboratorsByHero(hero);
        return new ResponseEntity<>(colaborators, HttpStatus.OK);
    }

    @GetMapping(value = "/characters/{hero}", produces = "application/json")
    @ApiOperation(value = "Buscar los otros héroes",
            notes = "Obtendremos los otros héroes con los cuales nuestro personaje ha interactuadoen cada uno de los cómics.",
            response = CharacterTO.class,
            produces = "application/json")
    public ResponseEntity<CharacterTO> getAllCharacters(@PathVariable("hero") String hero) {
        CharacterTO characters = this.characterFacade.getCharactersByHero(hero);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping(value = "/sync", produces = "application/json")
    @ApiOperation(value = "Sincroniza datos en BD",
            notes = "Actualiza todo el listado de escritores, editores y coloristas de cómics que han estado involucrados en las historias de los siguientes integrantes de los Vengadores",
            produces = "application/json")
    public ResponseEntity sync() {
        this.syncFacade.sync();
        return new ResponseEntity<>("BD Sincronizada", HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
