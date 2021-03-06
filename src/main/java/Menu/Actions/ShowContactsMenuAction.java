package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;

import java.util.List;


public class ShowContactsMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {

        List<Contact>Contacts= contactService.getAll();
        contactView.showContacts(Contacts);
        return contactService;
    }

    @Override
    public String getName() {
        return "Show all contacts";
    }
}
