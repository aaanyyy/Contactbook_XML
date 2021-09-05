package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadAllContactsMenuAction implements MenuAction{
    private final ContactService contactService;
    private final ContactView contactView;


    @Override
    public void doAction() {
        List<Contact>Contacts=contactService.getAll();
        contactView.showContacts(Contacts);
    }

    @Override
    public String getName() {
        return "Show all contacts";
    }
}
