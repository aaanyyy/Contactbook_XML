package Menu.Actions;

import Services.ContactService;
import UI.ContactView;


public class GetNamesMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String out = contactService.getAllNames();
        contactView.showAllNames(out);
        return contactService;
    }

    @Override
    public String getName() {
        return "Show all names (reduce example)";
    }

}
