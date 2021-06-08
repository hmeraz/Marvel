package mx.com.Marvel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "characters", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "hero")
    private String hero;
    @Column(name = "character")
    private String character;
    @Column(name = "comic")
    private String comic;
}
