package mx.com.Marvel.commons.to;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime; 
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class CharacterTO implements Serializable {

    private LocalDateTime last_sync;
    private List<CharacterDetailTO> characters;
}
