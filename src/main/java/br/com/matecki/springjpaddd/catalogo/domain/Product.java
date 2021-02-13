package br.com.matecki.springjpaddd.catalogo.domain;

import br.com.matecki.springjpaddd.shared.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity<String> {

    private String description;

    private Product() { }

    public Product(String name, String description) {
        super.id = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return id;
    }
}
