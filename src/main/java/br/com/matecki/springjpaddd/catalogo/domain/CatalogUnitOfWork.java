package br.com.matecki.springjpaddd.catalogo.domain;

import br.com.matecki.springjpaddd.shared.domainobjects.UnitOfWork;

public interface CatalogUnitOfWork extends UnitOfWork {
    ProductRepository getProductRepository();
}
