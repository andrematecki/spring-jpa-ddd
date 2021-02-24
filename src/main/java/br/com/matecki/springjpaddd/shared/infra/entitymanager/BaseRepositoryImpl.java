package br.com.matecki.springjpaddd.shared.infra.entitymanager;

import br.com.matecki.springjpaddd.shared.domain.BaseEntity;
import br.com.matecki.springjpaddd.shared.domain.BaseRepository;
import br.com.matecki.springjpaddd.shared.domain.QueryBase;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;

public abstract class BaseRepositoryImpl<Entity extends BaseEntity<Id>, Id>
        implements BaseRepository<Entity, Id>, DisposableBean {

    private final EntityManager em;

    protected BaseRepositoryImpl(EntityManagerFactory emf) {
        System.out.println("Thread: " +Thread.currentThread().getName()  + " | Criacao do Entity Manager");
        this.em = emf.createEntityManager();

    }

    public abstract Class<Entity> getClazz();


    @Override
    public Collection<Entity> findAll() {
        return em.createQuery( "from " + getClazz().getName() )
                .getResultList();
    }

    @Override
    public Entity save(Entity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public Collection<Entity> findAll(QueryBase query) {
        return em.createQuery( "from " + getClazz().getName() )
                .getResultList();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Thread: " +Thread.currentThread().getName()  + " | Encerramento do Entity Manager");
        if(em != null)
            em.close();

    }
}
