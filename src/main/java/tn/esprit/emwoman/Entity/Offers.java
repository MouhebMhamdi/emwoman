package tn.esprit.emwoman.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offers")
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String offerType;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "offers",cascade = CascadeType.ALL)
    private List<Postulant> postulants;


}
