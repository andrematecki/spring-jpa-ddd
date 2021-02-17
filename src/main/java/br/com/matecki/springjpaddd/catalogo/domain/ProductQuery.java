package br.com.matecki.springjpaddd.catalogo.domain;

import br.com.matecki.springjpaddd.shared.domain.QueryBase;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductQuery implements QueryBase {
    private String name;
}
