package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import Services.CsvFileContactService;
import UI.ContactView;

import java.util.List;


public
class ReadFromCsvMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        contactService =new CsvFileContactService();
        ((CsvFileContactService) contactService).loadFromFile(fileName);
        List<Contact>Contacts= contactService.getAll();
        contactView.showContacts(Contacts);

        return contactService;
    }

    @Override
    public String getName() {
        return "Load contacts from a CSV file";
    }
}
