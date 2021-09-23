package Menu.Actions;

import Models.Contact;
import Services.BinaryFileContactService;
import Services.ContactService;
import Services.InFileContactService;
import Services.XmlFileContactService;
import UI.ContactView;

import java.util.List;


public
class ReadFromXmlMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        contactService =new XmlFileContactService();
        ((InFileContactService) contactService).loadFromFile(fileName);
        List<Contact>Contacts= contactService.getAll();
        contactView.showContacts(Contacts);

        return contactService;
    }

    @Override
    public String getName() {
        return "Load contacts from a XML file";
    }
}
