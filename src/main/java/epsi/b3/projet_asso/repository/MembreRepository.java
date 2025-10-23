package epsi.b3.projet_asso.repository;

import java.util.List;
import epsi.b3.projet_asso.entity.Membre;
import org.springframework.data.repository.CrudRepository;

public interface MembreRepository extends CrudRepository<Membre, Long> {

    List<Membre> findByPrenom(String prenom);
    List<Membre> findByNom(String nom);

    Membre findById(long id);

}
