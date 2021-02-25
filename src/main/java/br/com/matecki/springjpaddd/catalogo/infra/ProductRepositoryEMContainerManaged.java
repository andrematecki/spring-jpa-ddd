package br.com.matecki.springjpaddd.catalogo.infra;


import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.NotFoundException;
import br.com.matecki.springjpaddd.shared.infra.BaseRepositoryEMContainerManaged;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository("ProductRepositoryEMContainerManaged")
public class ProductRepositoryEMContainerManaged
        extends BaseRepositoryEMContainerManaged<Product, String>
        implements ProductRepository {


    protected ProductRepositoryEMContainerManaged(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Product> getClazz() {
        return Product.class;
    }


    @Override
    public boolean productIsActive(String productName) throws NotFoundException {
        Product product = findById(productName);
        if(product == null)
            throw new NotFoundException();
        return product.isActive();
    }
}
