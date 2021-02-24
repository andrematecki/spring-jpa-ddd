package br.com.matecki.springjpaddd.catalogo.infra.jpa;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductQuery;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.domain.QueryBase;
import br.com.matecki.springjpaddd.shared.infra.jpa.BaseRepositoryImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository("ProductRepositoryImplJPA")
public class ProductRepositoryImpl
        extends BaseRepositoryImpl<Product, String>
        implements ProductRepository {

    public ProductRepositoryImpl(ProductRepositoryJpa jpa)
    {
        super(jpa, jpa);
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
}
