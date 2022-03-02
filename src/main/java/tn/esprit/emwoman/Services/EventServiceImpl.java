package tn.esprit.emwoman.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.emwoman.Entity.Events;
import tn.esprit.emwoman.Entity.Participant;
import tn.esprit.emwoman.Entity.User;
import tn.esprit.emwoman.Repositories.UserRepository;
import tn.esprit.emwoman.Repositories.EventsRepository;
import tn.esprit.emwoman.Repositories.ParticipantRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventsService{
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public List<Events> afficherTousLesEvenements() {
        return eventsRepository.findAll();
    }

    @Override
    public Events afficherEventById(int idEvent) {
        return eventsRepository.findById(idEvent).orElse(null);
    }

    @Override
    public Events afficherEventByDate(Date date) {
        return eventsRepository.getEventsByDate(date);
    }

    @Override
    public Events ajouterEvent(Events events) {
        return eventsRepository.save(events);
    }

    @Override
    public Events modifierEvent(int idEvent,Events events) {
        Events event=eventsRepository.findById(idEvent).orElse(null);

        if(events.getDate()!=null) event.setDate(events.getDate());
        if(events.getEventTopic()!=null) event.setEventTopic(events.getEventTopic());
        if(events.getDescription()!=null) event.setDescription(events.getDescription());
        if(events.getImagePub()!=null)event.setImagePub(events.getImagePub());
        if(events.getVideoPub()!=null)event.setVideoPub(events.getVideoPub());
        if(events.getUser()!=null)event.setUser(events.getUser());

        return eventsRepository.save(event);
    }

    @Override
    public List<Events> supprimerEvent(int idEvent) {
        eventsRepository.deleteById(idEvent);
        return this.afficherTousLesEvenements();
    }

    @Override
    public void supprimerTousLesEvenements() {
        eventsRepository.deleteAll();
    }

    @Override
    public List<Events> supprimerAllEventsByDate(Date date) {
        return eventsRepository.deleteAllByDate(date);
    }

    @Override
    public Events affecterUserAEvent(int idEvent, int idUser) {
        Events ev=eventsRepository.findById(idEvent).get();
        User us=userRepository.findById(idUser).get();
        ev.setUser(us);

        return eventsRepository.save(ev);
    }

    @Override
    public Events affecterParticipantAEvent(int idEvent, List<Integer> idParticipant) {
        Events ev=eventsRepository.findById(idEvent).get();
        List<Participant> part=participantRepository.findAllById(idParticipant);
        ev.setParticipant(part);

        return eventsRepository.save(ev);
    }

    @Override
    public Double sommeDonation() {
        return eventsRepository.sommeDonation();
    }

    @Override
    public int nbrDonation() {
        return eventsRepository.nbrDonation();
    }
}
