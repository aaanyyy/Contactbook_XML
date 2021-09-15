package Services;

import Models.Contact;
import Util.ListUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@AllArgsConstructor
public abstract class InFileContactService implements ContactService {
    List<Contact> cash;
    File file;

    public InFileContactService(List<Contact>contactList,String fileName) {

        file = new File(fileName);
        cash=contactList;
        save(cash);
    }

    abstract List<Contact> load();

    abstract void save(List<Contact> contactList);
    public void saveToFile(String fileName)
    {
        file = new File(fileName);
        save(cash);
    }

    InputStream getInputStream() throws IOException {

        if (!file.isFile() || !file.exists())
            file.createNewFile();

        return new BufferedInputStream(new FileInputStream(file));

    }

    OutputStream getOutputStream() throws IOException {
        if (!file.isFile() || !file.exists())
            file.createNewFile();

        return new BufferedOutputStream(new FileOutputStream(file));

    }

    @Override
    public List<Contact> getAll() {
        return load();
    }

    @Override
    public boolean remove(int id) {

        List<Contact> contacts = load();
        if (contacts.stream().anyMatch(c -> c.getId().equals(id))) {
            contacts = contacts.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList());
            cash = null;
            save(contacts);
            return true;
        } else return false;


    }

    @Override
    public void add(Contact contact) {
        if (contact == null) {
            throw new UnsupportedOperationException();
        }

        List<Contact> contactList = load();
        Optional<Integer> maxId = contactList.stream().map(c -> c.getId()).max((id1, id2) -> id1.compareTo(id2));
        int max;
        if(!maxId.isPresent())
            max=0;
        else max=maxId.get();
        contact.setId(max + 1);
        contactList.add(contact);
        cash = null;
        save(contactList);
    }

    private Contact get(Integer id) {
        List<Contact> contactList = load();
        Optional<Contact> contact = contactList.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (contact.isPresent())
            return contact.get();
        else
            return null;


    }

    @Override
    public List<Contact> search(String nameStartsWith) {
        // List<Contact> result=new ArrayList<Contact>();
        List<Contact> contactList = load();
        List<Contact> result = ListUtils.filter(contactList, elem -> elem.getName().startsWith(nameStartsWith));

        return result;
    }

    @Override
    public List<Contact> capitalizeName() {
        List<Contact> contactList = load();
        contactList = contactList.stream().map(contact -> contact.setName(contact.getName().toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
        cash = null;
        save(contactList);
        return contactList;
    }

    @Override
    public String getAllNames() {
        List<Contact> contactList = load();
        return
                ListUtils.reduce(contactList, "", (init, contact) -> init + contact.getName() + "\n");


    }

    public void loadFromFile(String fileName)
    {
        file = new File(fileName);
        cash=null;
        load();
    }

}
