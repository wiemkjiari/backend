package wiem.projetspringboot.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import wiem.projetspringboot.Model.Category;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    private Integer idEntreprise;
    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setIdEntreprise(categoryDto.getIdEntreprise());

        return category;
    }
}
