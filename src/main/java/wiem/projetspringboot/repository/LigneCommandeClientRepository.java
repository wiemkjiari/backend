package wiem.projetspringboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {


    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

    List<LigneCommandeClient> findAllByArticleId(Integer id);
}
