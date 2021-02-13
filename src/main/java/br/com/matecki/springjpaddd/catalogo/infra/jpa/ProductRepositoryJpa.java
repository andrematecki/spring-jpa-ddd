package br.com.matecki.springjpaddd.catalogo.infra.jpa;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJpa extends JpaRepository<Product, String> {

}
