package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.Offers;
import tn.esprit.emwoman.Entity.Postulant;

import java.util.List;

@Repository
public interface PostulantRepository extends JpaRepository<Postulant, Integer> {
    Postulant getPostulantByOffers(Offers offers);
    List<Postulant> deletePostulantsByOffers(Offers offers);

}
