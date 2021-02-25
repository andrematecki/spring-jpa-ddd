package br.com.matecki.springjpaddd.catalogo.domain;

import br.com.matecki.springjpaddd.shared.domainobjects.QueryBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ProductQuery implements QueryBase {
    private String name;
}
