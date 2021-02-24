package br.com.matecki.springjpaddd.catalogo.infra.entitymanager;


import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.infra.entitymanager.BaseRepositoryImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManagerFactory;

@Repository("ProductRepositoryImplEM")
@RequestScope
public class ProductRepositoryImpl
        extends BaseRepositoryImpl<Product, String>
        implements ProductRepository {


    protected ProductRepositoryImpl(EntityManagerFactory emf) {
        super(emf);

    }

    @Override
    public Class<Product> getClazz() {
        return Product.class;
    }
}
