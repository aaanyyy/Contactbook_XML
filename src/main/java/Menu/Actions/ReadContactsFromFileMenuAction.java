package Menu.Actions;

import Models.Contact;
import Services.BinaryFileContactService;
import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public
class ReadContactsFromFileMenuAction implements MenuAction{
    private final ContactService contactService;
    private final ContactView contactView;


    @Override
    public void doAction() {
        String fileName=contactView.getFileName();
        ((BinaryFileContactService)contactService).loadFromFile(fileName);
        List<Contact>Contacts=contactService.getAll();
        contactView.showContacts(Contacts);
    }

    @Override
    public String getName() {
        return "Load contacts from a file";
    }
}
