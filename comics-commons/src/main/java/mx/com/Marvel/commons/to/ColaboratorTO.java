package mx.com.Marvel.commons.to;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;  
import java.util.List;

@Getter
@Setter
public class ColaboratorTO implements Serializable {

    private LocalDateTime last_sync;
    private List<String> editors;
    private List<String> writers;
    private List<String> colorists;
}
