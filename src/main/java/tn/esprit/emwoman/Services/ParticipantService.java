package tn.esprit.emwoman.Services;

import tn.esprit.emwoman.Entity.Participant;

import java.util.List;

public interface ParticipantService {
    Participant ajouterParticipant(Participant participant);
    List<Participant> afficherTousLesParticipants();

}
