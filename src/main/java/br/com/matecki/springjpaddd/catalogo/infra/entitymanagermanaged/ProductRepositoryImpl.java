package br.com.matecki.springjpaddd.catalogo.infra.entitymanagermanaged;


import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.infra.entitymanagermanaged.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository("ProductRepositoryImplEMManaged")
public class ProductRepositoryImpl
        extends BaseRepositoryImpl<Product, String>
        implements ProductRepository {


    protected ProductRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Product> getClazz() {
        return Product.class;
    }
}
