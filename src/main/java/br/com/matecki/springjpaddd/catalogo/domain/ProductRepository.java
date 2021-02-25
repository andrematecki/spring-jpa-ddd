package br.com.matecki.springjpaddd.catalogo.domain;

import br.com.matecki.springjpaddd.shared.domainobjects.BaseRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.NotFoundException;

public interface ProductRepository extends BaseRepository<Product, String> {
    boolean productIsActive(String productName) throws NotFoundException;
}
