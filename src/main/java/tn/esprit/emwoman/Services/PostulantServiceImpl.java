package tn.esprit.emwoman.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.emwoman.Entity.Cv;
import tn.esprit.emwoman.Entity.Offers;
import tn.esprit.emwoman.Entity.Postulant;
import tn.esprit.emwoman.Repositories.CvRepository;
import tn.esprit.emwoman.Repositories.OffersRepository;
import tn.esprit.emwoman.Repositories.PostulantRepository;

import java.util.List;

@Service
public class PostulantServiceImpl implements PostulantService{

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    CvService cvService;
    @Override
    public Postulant ajouterPostulant(Postulant postulant) {
        return postulantRepository.save(postulant);
    }

    @Override
    public Postulant updatePostulant(Postulant postulant, int idPostulant) {
        Postulant p=postulantRepository.findById(idPostulant).orElse(null);
        if(postulant.getCv()!=null) p.setCv(postulant.getCv());
        if(postulant.getDate()!=null)p.setDate(postulant.getDate());
        if(postulant.getOffers()!=null) p.setOffers(postulant.getOffers());
        if(postulant.getName()!=null) p.setName(postulant.getName());
        return postulantRepository.save(p);
    }

    @Override
    public List<Postulant> getAllPostulant() {
        return postulantRepository.findAll();
    }

    @Override
    public Postulant getPostulantById(int idPostulant) {
        return postulantRepository.findById(idPostulant).orElse(null);
    }

    @Override
    public Postulant getPostulantByOffer(int idOffer) {
        return postulantRepository.getPostulantByOffers(offersRepository.findById(idOffer).get());
    }

    @Override
    public List<Postulant> deletePostulantById(int idPostulant) {
        postulantRepository.deleteById(idPostulant);
        return this.getAllPostulant();
    }

    @Override
    public void deleteAllPostulant() {
        postulantRepository.deleteAll();
    }

    @Override
    public List<Postulant> deletePostulantByoffer(Offers offers) {
        return postulantRepository.deletePostulantsByOffers(offers);
    }

    @Override
    public Postulant affecterOffreToPostulant(int idOffre, int idPostulant) {
        Offers offers=offersRepository.findById(idOffre).get();
        Postulant part=postulantRepository.findById(idPostulant).get();
        part.setOffers(offers);
        return postulantRepository.save(part);
    }

    @Override
    public Postulant affecterCvToPostulant(int postulantId, int cvId) {
        Postulant postulant=postulantRepository.findById(postulantId).get();
        Cv cv=cvService.getCvById(cvId);
        postulant.setCv(cv);
        return postulantRepository.save(postulant);
    }
}
