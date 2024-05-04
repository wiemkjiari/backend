package wiem.projetspringboot.services;

import wiem.projetspringboot.Dto.ArticleDto;
import wiem.projetspringboot.Dto.LigneCommandeClientDto;
import wiem.projetspringboot.Dto.LigneCommandeFournisseurDto;
import wiem.projetspringboot.Dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);

}
