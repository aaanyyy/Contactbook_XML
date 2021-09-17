package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;

import java.util.List;


public class ShowInCapitalMenuAction implements MenuAction {


    @Override
        public ContactService doAction(ContactService contactService, ContactView contactView) {
            List<Contact> Contacts= contactService.capitalizeName();
            contactView.showContacts(Contacts);
            return contactService;
        }

        @Override
        public String getName() {
            return "Make names in capital letters (map example)";
        }
    }

