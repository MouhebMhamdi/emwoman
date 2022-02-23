package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.Cv;
@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {
}
