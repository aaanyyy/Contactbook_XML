package Services;

import Models.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();
    boolean remove (int index);
    void add (Contact contact);
    List<Contact> search(String nameStartsWith);
    List<Contact> capitalizeName();
    String getAllNames();



}
