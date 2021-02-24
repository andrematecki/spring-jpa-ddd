package br.com.matecki.springjpaddd.shared.infra.entitymanagermanaged;

import br.com.matecki.springjpaddd.shared.domain.BaseEntity;
import br.com.matecki.springjpaddd.shared.domain.BaseRepository;
import br.com.matecki.springjpaddd.shared.domain.QueryBase;
import org.springframework.beans.factory.DisposableBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;

public abstract class BaseRepositoryImpl<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id> {

    private final EntityManager em;

    protected BaseRepositoryImpl(EntityManager em) {
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
    public Collection<Entity> findAll(QueryBase query) {
        return em.createQuery( "from " + getClazz().getName() )
                .getResultList();
    }

}
