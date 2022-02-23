package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.Offers;
import tn.esprit.emwoman.Entity.User;

import java.util.List;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Integer> {
    List<Offers> getOffersByUser(User user);
}
