package Menu.Actions;

import Services.ContactService;
import UI.ContactView;


public class RemoveContactMenuAction implements MenuAction {

    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        contactService.remove(contactView.getContactIdToDelete());

        return contactService;
    }

    @Override
    public String getName() {
        return "Delete contact";
    }
}