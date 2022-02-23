package tn.esprit.emwoman.Services;

import tn.esprit.emwoman.Entity.Events;

import java.util.Date;
import java.util.List;

public interface EventsService {

    List<Events> afficherTousLesEvenements();

    Events afficherEventById(int idEvent);

    Events afficherEventByDate(Date date);


    Events ajouterEvent(Events events);

    Events modifierEvent(int idEvent,Events events);

    List<Events> supprimerEvent(int idEvent);

    void supprimerTousLesEvenements();

    List<Events> supprimerAllEventsByDate(Date date);

    Events affecterUserAEvent(int idEvent,int idUser);

    Events affecterParticipantAEvent(int idEvent,int idParticipant);

    Double sommeDonation();

    int nbrDonation();

}
