package Menu.Actions;

import Services.ContactService;
import UI.ContactView;

public class ExitMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {

        return contactService;
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public boolean closeAfter() {
        return true;
    }

}
