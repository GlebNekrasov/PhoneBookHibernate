package ru.academits.nekrasovgleb.dao;

import org.springframework.stereotype.Repository;
import ru.academits.nekrasovgleb.model.Contact;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ContactDaoImpl extends GenericDaoImpl<Contact, Long> implements ContactDao {
    public ContactDaoImpl() {
        super(Contact.class);
    }

    @Override
    public List<Contact> getAllContacts() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(clazz);

        Root<Contact> root = cq.from(clazz);

        cq.where(cb.equal(root.get("isRemoved"), false));

        CriteriaQuery<Contact> select = cq.select(root);
        TypedQuery<Contact> q = entityManager.createQuery(select);

        return q.getResultList();
    }

    @Override
    public List<Contact> findByPhone(String phone) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(clazz);

        Root<Contact> root = cq.from(clazz);

        cq.where(cb.and(cb.equal(root.get("phone"), phone), cb.equal(root.get("isRemoved"), false)));

        CriteriaQuery<Contact> select = cq.select(root);
        TypedQuery<Contact> q = entityManager.createQuery(select);

        return q.getResultList();
    }

    @Override
    public void delete(int[] idsToDelete) {
        for (int id : idsToDelete) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Contact> cq = cb.createQuery(clazz);

            Root<Contact> root = cq.from(clazz);

            cq.select(root);

            cq.where(cb.equal(root.get("id"), id));

            CriteriaQuery<Contact> select = cq.select(root);
            TypedQuery<Contact> q = entityManager.createQuery(select);

            Contact contactToDelete = q.getResultList().get(0);
            contactToDelete.setIsRemoved(true);
        }
    }
}