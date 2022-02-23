package tn.esprit.emwoman.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.emwoman.Entity.Offers;
import tn.esprit.emwoman.Entity.User;
import tn.esprit.emwoman.Repositories.OffersRepository;
import tn.esprit.emwoman.Repositories.UserRepository;

import java.util.List;

@Service
public class OffreServiceImpl implements OffreService{
    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

    @Override
    public Offers getOfferById(int idOffre) {
        return offersRepository.findById(idOffre).get();
    }

    @Override
    public List<Offers> getOfferByUser(int iduser) {
        return offersRepository.getOffersByUser(userRepository.findById(iduser).get());
    }

    @Override
    public Offers addOffer(Offers offers) {
        return offersRepository.save(offers);
    }

    @Override
    public Offers updateOffer(int idOffre, Offers offers) {
        Offers of=offersRepository.findById(idOffre).orElse(null);
        if(offers.getOfferType()!=null) of.setOfferType(offers.getOfferType());
        if(offers.getPostulants()!=null) of.setPostulants(offers.getPostulants());
        if(offers.getUser()!=null)of.setUser(offers.getUser());
        return offersRepository.save(of);
    }

    @Override
    public List<Offers> deleteOffreById(int idoffre) {
        offersRepository.deleteById(idoffre);
        return this.getAllOffers();
    }

    @Override
    public void deleteAllOffres() {
        offersRepository.deleteAll();
    }

    @Override
    public Offers affecterUserToOffer(int idOffre, int idUser) {
        Offers of=offersRepository.findById(idOffre).get();
        User us=userRepository.findById(idUser).get();
        of.setUser(us);
        return offersRepository.save(of);
    }
}
