package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.Cv;
import tn.esprit.emwoman.Entity.Postulant;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {

    @Query("SELECT P FROM Postulant P,Cv C join P.cv CP on C=CP AND P.id=:idPostulant")
    Cv getCvByPostulants(int idPostulant);

}
