package br.com.matecki.springjpaddd.catalogo.presentation;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String description;

    public ProductDto(Product p){
        this.name = p.getName();
        this.description = p.getDescription();
    }

}
