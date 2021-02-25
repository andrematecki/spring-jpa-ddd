package br.com.matecki.springjpaddd.catalogo.presentation;

import br.com.matecki.springjpaddd.catalogo.domain.Product;
import br.com.matecki.springjpaddd.catalogo.domain.ProductQuery;
import br.com.matecki.springjpaddd.catalogo.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/em_app_managed/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(@Qualifier("ProductRepositorySpringJPA") ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @GetMapping
    public Collection<ProductDto> index() {
        Product laptop = new Product("MacBook Pro", "MacBook Pro 14 inch MID 2019");
        repository.save(laptop);

        var list = repository.findAll();
        return list.stream().map(p -> { return new ProductDto(p);}).collect(Collectors.toList());
    }


    @GetMapping
    @RequestMapping("/index2")
    public Collection<ProductDto> index2() {
        Product laptop = new Product("MacBook Pro", "MacBook Pro 14 inch MID 2019");
        repository.save(laptop);

        Product laptop2 = new Product("McBook Pro", "MacBook Pro 14 inch MID 2019");
        repository.save(laptop2);

        var list = repository.findAll(new ProductQuery("Mac"));
        return list.stream().map(p -> { return new ProductDto(p);}).collect(Collectors.toList());
    }
}
