package tn.esprit.emwoman.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
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

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private  String Firstname;
    private  String LastName;
    private String Password;
    private String adress;
    private String email;
    private int phoneNumber;
    private  String confirmPassword;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Events> events;

    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    private List<Offers> offers;
}
