package wiem.projetspringboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.Ventes;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

    Optional<Ventes> findVentesByCode(String code);
}