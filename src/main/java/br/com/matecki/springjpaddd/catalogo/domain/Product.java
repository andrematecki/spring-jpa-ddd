package br.com.matecki.springjpaddd.catalogo.domain;

import br.com.matecki.springjpaddd.shared.domainobjects.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity<String> {

    private String description;
    private boolean active;

    private Product() { }

    public Product(String name, String description) {
        super.id = name;
        this.description = description;
        this.active = true;
    }

    public void deactivate(){ this.active = false; }

    public void activate(){ this.active = true; }

    public boolean isActive() { return active; }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return id;
    }
}
