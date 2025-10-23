package epsi.b3.projet_asso.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import epsi.b3.projet_asso.entity.Membre;
import epsi.b3.projet_asso.repository.MembreRepository;

@RestController
@RequestMapping("membres")
public class MembreRestController {

    private final MembreRepository membreRepository;

    MembreRestController(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    //Appeler tous les membres
    @GetMapping("/")
    public Iterable<Membre> getAllMembres() {
        return membreRepository.findAll();
    }

    //Appeler un membre par son ID
    @GetMapping("/{id}")
    public ResponseEntity <Membre> GetSomeoneById(@PathVariable long id) {
        Optional <Membre> someone = membreRepository.findById(id);
        if (someone.isPresent()) {
            return ResponseEntity.ok(someone.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
