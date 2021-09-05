package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindContactsMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        String stringToFind=contactView.getStringToSearch();
        List<Contact> contacts=contactService.search(stringToFind);
        contactView.showContacts(contacts);
    }

    @Override
    public String getName() {
        return "Find a contact by a name (filter example)";
    }
}
