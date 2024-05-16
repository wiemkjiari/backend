package wiem.projetspringboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	Optional<Utilisateur> findByEmail(String email);

}
