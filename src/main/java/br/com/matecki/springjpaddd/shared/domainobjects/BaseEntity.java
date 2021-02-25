package br.com.matecki.springjpaddd.shared.domainobjects;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity <Id>{
    @javax.persistence.Id
    protected Id id;

    public Id getId() {
        return id;
    }
}
