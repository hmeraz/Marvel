package mx.com.Marvel.commons.to;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CharacterDetailTO implements Serializable {

    private String character;
    private List<String> Comics;
}
