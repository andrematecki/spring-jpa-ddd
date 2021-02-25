package br.com.matecki.springjpaddd.shared.domainobjects;

import java.util.Collection;

public interface BaseRepository <Entity extends BaseEntity<Id>, Id> {

    Collection<Entity> findAll();
    Entity save(Entity entity);
    Entity findById(Id id);
    Collection<Entity> findAll(QueryBase query);


}
