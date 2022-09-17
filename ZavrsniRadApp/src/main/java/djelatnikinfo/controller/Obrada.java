/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import djelatnikinfo.model.Entitet;
import java.util.List;
import djelatnikinfo.util.HibernateUtil;
import org.hibernate.Session;

import djelatnikinfo.util.AppException;

/**
 *
 * @author Alen
 */
public abstract class Obrada<T extends Entitet> {

    protected T entitet;
    protected Session session;

    public abstract List<T> read();

    protected abstract void kontrolaCreate() throws AppException;

    protected abstract void kontrolaUpdate() throws AppException;

    protected abstract void kontrolaDelete() throws AppException;

    protected abstract String getNazivEntiteta();

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }

    public void create() throws AppException {
        if (entitet == null) {
            throw new AppException(getNazivEntiteta() + " nije  konstruiran");
        }
        kontrolaCreate();
        persist();
    }

    public void update() throws AppException {
        kontrolaUpdate();
        persist();
    }

    public void delete() throws AppException {
        kontrolaDelete();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();

    }

    private void persist() {
        session.beginTransaction();
        session.persist(this.entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

}
