package br.com.matecki.springjpaddd.catalogo.infra.jpa;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.infra.jpa.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl
        extends BaseRepositoryImpl<Product, String>
        implements ProductRepository {

    protected ProductRepositoryImpl(JpaRepository<Product, String> jpa) {
        super(jpa);
    }
}
