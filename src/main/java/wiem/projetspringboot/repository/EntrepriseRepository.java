package wiem.projetspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}