package wiem.projetspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.CommandeClient;

import java.util.List;
import java.util.Optional;
    public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

        Optional<CommandeClient> findCommandeClientByCode(String code);

        List<CommandeClient> findAllByClientId(Integer id);
}
