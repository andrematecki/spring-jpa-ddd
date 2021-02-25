package br.com.matecki.springjpaddd.shared.infra;

import br.com.matecki.springjpaddd.shared.domainobjects.BaseEntity;
import br.com.matecki.springjpaddd.shared.domainobjects.BaseRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.QueryBase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

public abstract class BaseRepositorySpringJPA<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id> {

    protected final JpaRepository<Entity, Id> jpaRepository;
    protected final JpaSpecificationExecutor<Entity> jpaSpecificationExecutor;

    protected BaseRepositorySpringJPA(JpaRepository<Entity, Id> jpaRepository, JpaSpecificationExecutor<Entity> jpaSpecificationExecutor) {
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
    public Entity findById(Id id) { return jpaRepository.getOne(id); }

    @Override
    public Collection<Entity> findAll(QueryBase query) {
        return jpaSpecificationExecutor.findAll(getSpecification(query));
    }

    protected abstract Specification<Entity> getSpecification(QueryBase query);
}
