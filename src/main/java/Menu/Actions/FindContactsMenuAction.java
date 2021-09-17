package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;

import java.util.List;


public class FindContactsMenuAction implements MenuAction {



    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String stringToFind= contactView.getStringToSearch();
        List<Contact> contacts= contactService.search(stringToFind);
        contactView.showContacts(contacts);

        return contactService;
    }

    @Override
    public String getName() {
        return "Find a contact by a name (filter example)";
    }

}
