package br.com.matecki.springjpaddd.shared.domainobjects;

public interface UnitOfWork {
    void beginChanges();
    void commitChanges();
    void rollbackChanges();
}
