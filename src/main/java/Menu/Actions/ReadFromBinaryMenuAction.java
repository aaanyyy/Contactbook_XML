package Menu.Actions;

import Models.Contact;
import Services.BinaryFileContactService;
import Services.ContactService;
import UI.ContactView;

import java.util.List;


public
class ReadFromBinaryMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        contactService =new BinaryFileContactService();
        ((BinaryFileContactService) contactService).loadFromFile(fileName);
        List<Contact>Contacts= contactService.getAll();
        contactView.showContacts(Contacts);

        return contactService;
    }

    @Override
    public String getName() {
        return "Load contacts from a binary file";
    }
}
