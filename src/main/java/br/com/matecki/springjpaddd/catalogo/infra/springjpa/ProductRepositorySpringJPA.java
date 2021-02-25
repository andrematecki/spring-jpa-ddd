package br.com.matecki.springjpaddd.catalogo.infra.springjpa;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductQuery;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.NotFoundException;
import br.com.matecki.springjpaddd.shared.domainobjects.QueryBase;
import br.com.matecki.springjpaddd.shared.infra.BaseRepositorySpringJPA;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Repository("ProductRepositorySpringJPA")
public class ProductRepositorySpringJPA
        extends BaseRepositorySpringJPA<Product, String>
        implements ProductRepository {

    private final ProductJpaRepository jpa;
    public ProductRepositorySpringJPA(ProductJpaRepository jpa)
    {
        super(jpa, jpa);
        this.jpa = jpa;
    }


    @Override
    protected Specification<Product> getSpecification(QueryBase query) {
        return
            (Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) ->
            {
                ProductQuery pq = (ProductQuery) query;
                if (pq.getName() != null && pq.getName() != "")
                    return criteriaBuilder.like(root.get("id"), "%" + pq.getName()+ "%");
                return null;
            };
    }

    @Override
    public boolean productIsActive(String productName) throws NotFoundException {
        Optional<Product> product = jpa.findById(productName);
        if(! product.isPresent())
            throw new NotFoundException();
        return product.get().isActive();
    }
}
