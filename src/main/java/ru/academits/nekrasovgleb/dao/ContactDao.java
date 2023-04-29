package ru.academits.nekrasovgleb.dao;

import ru.academits.nekrasovgleb.model.Contact;

import java.util.List;

public interface ContactDao extends GenericDao<Contact, Long> {
    List<Contact> getAllContacts();

    List<Contact> findByPhone(String phone);

    void delete(int[] idsToDelete);
}
