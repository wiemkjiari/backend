package wiem.projetspringboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.LigneCommandeFournisseur;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer> {

    List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Integer idCommande);

    List<LigneCommandeFournisseur> findAllByArticleId(Integer idCommande);
}
