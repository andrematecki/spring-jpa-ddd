package br.com.matecki.springjpaddd.catalogo.infra.springjpa;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductJpaRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

}
