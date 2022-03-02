package tn.esprit.emwoman.Services;

import tn.esprit.emwoman.Entity.Offers;
import tn.esprit.emwoman.Entity.Postulant;

import java.util.List;

public interface PostulantService {

    Postulant ajouterPostulant(Postulant postulant);
    Postulant updatePostulant(Postulant postulant,int idPostulant);
    List<Postulant> getAllPostulant();
    Postulant getPostulantById(int idPostulant);
    Postulant getPostulantByOffer(int idOffer);
    List<Postulant> deletePostulantById(int idPostulant);
    void deleteAllPostulant();
    List<Postulant> deletePostulantByoffer(Offers offers);

    Postulant affecterOffreToPostulant(int idOffre,int idPostulant);

    Postulant affecterCvToPostulant(int postulantId,int cvId);




}
