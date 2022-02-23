package tn.esprit.emwoman.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.emwoman.Entity.Participant;
import tn.esprit.emwoman.Services.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("/api/participant")

public class ParticipantController {
    @Autowired
    private ParticipantService participantService;


    @GetMapping("/all")
    public List<Participant> getAllParticipants(){
        return participantService.afficherTousLesParticipants();
    }

    @PostMapping("/add")
    public List<Participant> ajouterParticipant(@RequestBody Participant participant){
        participantService.ajouterParticipant(participant);
        return this.getAllParticipants();
    }


}
