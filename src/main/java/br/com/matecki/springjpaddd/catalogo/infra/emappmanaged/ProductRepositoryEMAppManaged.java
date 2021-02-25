package br.com.matecki.springjpaddd.catalogo.infra.emappmanaged;


import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.NotFoundException;
import br.com.matecki.springjpaddd.shared.infra.emappmanaged.BaseRepositoryEMAppManaged;

import javax.persistence.EntityManager;

public class ProductRepositoryEMAppManaged
        extends BaseRepositoryEMAppManaged<Product, String>
        implements ProductRepository {


    public ProductRepositoryEMAppManaged(EntityManager em) {
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
