package br.com.matecki.springjpaddd.catalogo.infra.emappmanaged;

import br.com.matecki.springjpaddd.catalogo.domain.CatalogUnitOfWork;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.infra.emappmanaged.UnitOfWorkEMAppManaged;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManagerFactory;

@Repository
@RequestScope
public class CatalogUnitOfWorkEMAppManaged
        extends UnitOfWorkEMAppManaged
        implements CatalogUnitOfWork {

    private ProductRepository productRepository;

    public CatalogUnitOfWorkEMAppManaged(EntityManagerFactory emf) {
        super(emf.createEntityManager());
        productRepository = new ProductRepositoryEMAppManaged(em);
    }

    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
