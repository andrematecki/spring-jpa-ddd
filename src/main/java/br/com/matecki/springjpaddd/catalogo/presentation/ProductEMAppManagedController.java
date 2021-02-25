package br.com.matecki.springjpaddd.catalogo.presentation;

import br.com.matecki.springjpaddd.catalogo.domain.CatalogUnitOfWork;
import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.TestError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/em_app_managed/products/")
public class ProductEMAppManagedController {

    private final CatalogUnitOfWork unitOfWork;


    public ProductEMAppManagedController(CatalogUnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    @RequestMapping("insert_product_success")
    @GetMapping
    public ProductDto insertProductSuccess() throws TestError {


        Product laptop = new Product("MacBook Pro", "MacBook Pro 14 inch MID 2019");
        unitOfWork.beginChanges();
        unitOfWork.getProductRepository().save(laptop);
        unitOfWork.commitChanges();

        Product p = unitOfWork.getProductRepository().findById("MacBook Pro");
        if(p != null)
            return new ProductDto(p);

        throw new TestError();
    }

}
