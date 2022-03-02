package tn.esprit.emwoman.Services;

import tn.esprit.emwoman.Entity.Cv;

import java.util.List;

public interface CvService {
    Cv ajouterCv(Cv cv);
    Cv getCvById(int cv);
    List<Cv> getAllCv();
    Cv getCvByPostulant(int idPostulant);
    List<Cv> deleteCvById(int idCv);
    void deleteAllCvs();
    Cv updateCv(Cv cv,int idCv);
}
