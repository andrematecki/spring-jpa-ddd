package br.com.matecki.springjpaddd.shared.infra.emappmanaged;

import br.com.matecki.springjpaddd.shared.domainobjects.BaseEntity;
import br.com.matecki.springjpaddd.shared.domainobjects.BaseRepository;
import br.com.matecki.springjpaddd.shared.domainobjects.QueryBase;
import org.springframework.beans.factory.DisposableBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;

public abstract class BaseRepositoryEMAppManaged<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id> {

    private final EntityManager em;


    public BaseRepositoryEMAppManaged(EntityManager em) {
        this.em = em;
        System.out.println("Thread: " +Thread.currentThread().getName()  + " | Criacao do Entity Manager");
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

    @Override
    public Entity findById(Id id){
        return em.find(getClazz(), id);
    }
}
