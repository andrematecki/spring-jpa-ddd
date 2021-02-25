package br.com.matecki.springjpaddd.shared.infra;

import br.com.matecki.springjpaddd.shared.domainobjects.BaseEntity;
import br.com.matecki.springjpaddd.shared.domainobjects.BaseRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.QueryBase;

import javax.persistence.EntityManager;
import java.util.Collection;

public abstract class BaseRepositoryEMContainerManaged<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id> {

    private final EntityManager em;

    protected BaseRepositoryEMContainerManaged(EntityManager em) {
        System.out.println("Thread: " +Thread.currentThread().getName()  + " | Criacao do Entity Manager | EntityManager: " + em.toString());
        this.em = em;

    }

    public abstract Class<Entity> getClazz();


    @Override
    public Collection<Entity> findAll() {
        return em.createQuery( "from " + getClazz().getName() )
                .getResultList();
    }

    @Override
    public Entity save(Entity entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Entity findById(Id id){
        return em.find(getClazz(), id);
    }


    @Override
    public Collection<Entity> findAll(QueryBase query) {
        return em.createQuery( "from " + getClazz().getName() )
                .getResultList();
    }

}
