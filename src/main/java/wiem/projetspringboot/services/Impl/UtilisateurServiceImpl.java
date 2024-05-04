package wiem.projetspringboot.services.Impl;


import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import wiem.projetspringboot.Dto.ChangerMotDePasseUtilisateurDto;
import wiem.projetspringboot.Dto.UtilisateurDto;

import wiem.projetspringboot.exeption.EntityNotFoundException;
import wiem.projetspringboot.exeption.ErrorCodes;

import wiem.projetspringboot.repository.UtilisateurRepository;
import wiem.projetspringboot.services.UtilisateurService;

import java.util.List;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return null;
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return null;
    }

    @Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        return null;
    }
}
