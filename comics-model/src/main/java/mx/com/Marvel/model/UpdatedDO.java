package mx.com.Marvel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.*; 

@Getter
@Setter
@Entity
@Table(name = "updates", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedDO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDateTime date;
}
