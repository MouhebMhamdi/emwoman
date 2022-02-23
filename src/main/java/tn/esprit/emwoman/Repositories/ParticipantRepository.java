package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.Participant;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
