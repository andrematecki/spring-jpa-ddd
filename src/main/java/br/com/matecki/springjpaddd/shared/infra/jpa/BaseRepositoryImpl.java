package br.com.matecki.springjpaddd.shared.infra.jpa;

import br.com.matecki.springjpaddd.shared.domain.BaseEntity;
import br.com.matecki.springjpaddd.shared.domain.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public abstract class BaseRepositoryImpl<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id> {

    private final JpaRepository<Entity, Id> jpa;

    protected BaseRepositoryImpl(JpaRepository<Entity, Id> jpa) {
        this.jpa = jpa;
    }

    @Override
    public Collection<Entity> findAll() {
        return jpa.findAll();
    }

    @Override
    public Entity save(Entity entity) {
        return jpa.save(entity);
    }
}
