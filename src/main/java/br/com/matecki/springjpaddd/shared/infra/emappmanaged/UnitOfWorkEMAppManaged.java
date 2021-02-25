package br.com.matecki.springjpaddd.shared.infra.emappmanaged;

import br.com.matecki.springjpaddd.shared.domainobjects.UnitOfWork;
import org.springframework.beans.factory.DisposableBean;

import javax.persistence.EntityManager;

public class UnitOfWorkEMAppManaged implements UnitOfWork, DisposableBean {

    protected final EntityManager em;

    public UnitOfWorkEMAppManaged(EntityManager em) {
        this.em = em;
    }

    private boolean transactionIsActive(){
        return em.getTransaction().isActive();
    }

    @Override
    public void beginChanges() {
        if(! transactionIsActive())
            em.getTransaction().begin();
    }

    @Override
    public void commitChanges() {
        if(transactionIsActive())
            em.getTransaction().commit();
    }

    @Override
    public void rollbackChanges() {
        if(transactionIsActive())
            em.getTransaction().rollback();

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Thread: " +Thread.currentThread().getName()  + " | Encerramento do Entity Manager");
        if(em != null)
            em.close();
    }
}
