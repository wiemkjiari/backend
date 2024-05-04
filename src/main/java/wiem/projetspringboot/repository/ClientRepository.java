package wiem.projetspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}