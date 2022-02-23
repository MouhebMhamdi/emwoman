package tn.esprit.emwoman.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.emwoman.Entity.Participant;
import tn.esprit.emwoman.Repositories.EventsRepository;
import tn.esprit.emwoman.Repositories.ParticipantRepository;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService{
    @Autowired
    private ParticipantRepository participantRepository;


    @Override
    public Participant ajouterParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public List<Participant> afficherTousLesParticipants() {
        return participantRepository.findAll();
    }
}
