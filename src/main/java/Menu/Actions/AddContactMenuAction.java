package Menu.Actions;

import Services.ContactService;
import UI.ContactView;


public class AddContactMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        contactService.add(contactView.readContact());


        return contactService;
    }

    @Override
    public String getName() {
        return "Add a contact";
    }

}
