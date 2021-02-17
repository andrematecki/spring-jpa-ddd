package br.com.matecki.springjpaddd.shared.infra.jpa;

import br.com.matecki.springjpaddd.shared.domain.BaseEntity;
import br.com.matecki.springjpaddd.shared.domain.BaseRepository;
import br.com.matecki.springjpaddd.shared.domain.QueryBase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

public abstract class BaseRepositoryImpl<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id> {

    protected final JpaRepository<Entity, Id> jpaRepository;
    protected final JpaSpecificationExecutor<Entity> jpaSpecificationExecutor;

    protected BaseRepositoryImpl(JpaRepository<Entity, Id> jpaRepository, JpaSpecificationExecutor<Entity> jpaSpecificationExecutor) {
        this.jpaRepository = jpaRepository;
        this.jpaSpecificationExecutor = jpaSpecificationExecutor;
    }

    @Override
    public Collection<Entity> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Entity save(Entity entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Collection<Entity> findAll(QueryBase query) {
        return jpaSpecificationExecutor.findAll(getSpecification(query));
    }

    protected abstract Specification<Entity> getSpecification(QueryBase query);
}
