package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShowInCapitalMenuAction implements MenuAction{


        private final ContactService contactService;
        private final ContactView contactView;

        @Override
        public void doAction() {
            List<Contact> Contacts=contactService.capitalizeName();
            contactView.showContacts(Contacts);

        }

        @Override
        public String getName() {
            return "Make names in capital letters (map example)";
        }
    }

