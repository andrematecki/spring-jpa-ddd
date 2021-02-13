package br.com.matecki.springjpaddd.shared.domain;

import br.com.matecki.springjpaddd.shared.domain.BaseEntity;

import java.util.Collection;

public interface BaseRepository <Entity extends BaseEntity<Id>, Id> {

    Collection<Entity> findAll();
    Entity save(Entity entity);

}
