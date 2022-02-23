package tn.esprit.emwoman.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String eventTopic;
    private String Description;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String VideoPub;
    private String ImagePub;

    @ManyToOne
    @JsonIgnore
    private User user;


    @ManyToMany
    @JsonIgnore
    private List<Participant> participant;



}
