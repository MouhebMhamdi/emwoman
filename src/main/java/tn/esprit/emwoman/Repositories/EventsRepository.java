package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.Events;

import java.util.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
    Events getEventsByDate(Date date);
    List<Events> deleteAllByDate(Date date);

    @Query("SELECT sum(P.donation) FROM Events E,Participant P join E.participant pp where pp=P")
    Double sommeDonation();

    @Query("SELECT count(P) FROM Events E,Participant P join E.participant pp where pp=P")
    int nbrDonation();




}
