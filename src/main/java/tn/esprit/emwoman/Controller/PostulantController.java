package tn.esprit.emwoman.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.emwoman.Entity.Postulant;
import tn.esprit.emwoman.Services.OffreService;
import tn.esprit.emwoman.Services.PostulantService;

import java.util.List;

@RestController
@RequestMapping("/api/postulant")
public class PostulantController {
    @Autowired
    private PostulantService postulantService;

    @Autowired
    private OffreService offreService;
    @GetMapping("/all")
    public List<Postulant> getAllPostulant(){
        return postulantService.getAllPostulant();
    }

    @GetMapping("/{id}")
    public Postulant getPostulantById(@PathVariable int id){
        return postulantService.getPostulantById(id);
    }

    @GetMapping("offre/{idoffre}")
    public Postulant getPostulantByOffre(@PathVariable int idoffre){
        return postulantService.getPostulantByOffer(idoffre);
    }

    @GetMapping("/offre/{idOffre}/{idpostulant}")
    public Postulant affecteroffreToPostulant(@PathVariable int idOffre,@PathVariable int idpostulant){
        return postulantService.affecterOffreToPostulant(idOffre,idpostulant);
    }

    @GetMapping("/affecterCvToPostulant/{idCv}/{idPostulant}")
    public Postulant affecterCvToPostulant(@PathVariable int idCv,@PathVariable int idPostulant){
        return postulantService.affecterCvToPostulant(idPostulant,idCv);
    }
    @PostMapping("/add")
    public Postulant addPostulant(@RequestBody Postulant postulant){
        return postulantService.ajouterPostulant(postulant);
    }


    @PutMapping("/update/{id}")
    public Postulant updatePostulant(@PathVariable int id,@RequestBody Postulant postulant){
        return postulantService.updatePostulant(postulant,id);
    }

    @DeleteMapping("/{id}")
    public List<Postulant> deletePostulant(@PathVariable int id){
        postulantService.deletePostulantById(id);
        return this.getAllPostulant();
    }

    @DeleteMapping("offre/{idoffre}")
    public List<Postulant> deletePostulantByoffre(@PathVariable int idoffre){
        postulantService.deletePostulantByoffer(offreService.getOfferById(idoffre));
        return this.getAllPostulant();
    }

    @DeleteMapping("/all")
    public String deleteAllPostulant(){
        postulantService.deleteAllPostulant();
        return "All postulant deleted";
    }


}
